package com.example.bookapplication.ui.fragment.catalog

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.bookapplication.R
import com.example.bookapplication.VOLUME_ID
import com.example.bookapplication.databinding.FragmentBooksCatalogBinding
import com.example.bookapplication.models.catalogmodel.Item
import com.example.bookapplication.models.catalogmodel.Saleability
import com.example.bookapplication.models.recyclermodel.RecyclerListModel
import com.example.bookapplication.ui.fragment.bookdetails.BookDetailsFragment
import com.example.bookapplication.ui.recyclerview.CatalogAdapter
import com.example.bookapplication.ui.recyclerview.callback.IRecyclerViewCallback
import org.koin.androidx.viewmodel.ext.android.viewModel

class BooksCatalogFragment : Fragment(), IRecyclerViewCallback {

    private val viewModel by viewModel<BooksCatalogViewModel>()
    private lateinit var binding: FragmentBooksCatalogBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_books_catalog, container, false
        )
        binding.lifecycleOwner = this
        binding.viewModel = this.viewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListener()
        createAdapters()
        configRecyclerLayout()
    }

    private fun createAdapters() {
        viewModel.catalog.observe(viewLifecycleOwner, {
            val adapter = it?.let { it1 ->
                CatalogAdapter(
                    configRecyclerList(it1),
//                    it.filter { item -> item.saleInfo.saleability == Saleability.FREE }.count(),
                    this,
                )
            }
            adapter?.notifyDataSetChanged()
            binding.bookCatalogRecyclerView.adapter = adapter
        })
    }

    private fun configRecyclerLayout() {
        viewModel.catalog.observe(viewLifecycleOwner, {
            binding.bookCatalogRecyclerView.layoutManager = GridLayoutManager(this.context, 2)
            viewModel.progressState.value = false
        })
    }

    private fun configRecyclerList(bookList: List<Item>): MutableList<RecyclerListModel> {
        val sortedBookList = bookList.sortedBy { it.saleInfo.saleability == Saleability.FREE }
        val recyclerList = mutableListOf<RecyclerListModel>()
        mutableListOf(
            context?.getString(
                R.string.free_books_title
            )?.let {
                RecyclerListModel.TitleItem(
                    it
                )
            },
            context?.getString(
                R.string.paid_books_title
            )?.let {
                RecyclerListModel.TitleItem(
                    it
                )
            },
        )
        sortedBookList.forEach { it ->
            recyclerList.add(
                RecyclerListModel.BookItem(
                    it.volumeInfo.title,
                    it.volumeInfo.imageLinks.thumbnail,
                    it.id
                )
            )
        }
        recyclerList.add(RecyclerListModel.DividerItem())
        return recyclerList
    }

    private fun initListener() {
        binding.searchEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                //do nothing
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                //do nothing
            }

            override fun afterTextChanged(editable: Editable) {
                viewModel.progressState.value = true
                viewModel.getBooksCatalog(editable.toString())
            }
        })
    }

    override fun onClickListener(bookId: String) {
        val bundle = Bundle()
        bundle.putString(VOLUME_ID, bookId)
        val fragment = BookDetailsFragment()
        fragment.arguments = bundle
        activity?.supportFragmentManager?.beginTransaction()
            ?.replace(R.id.fragment_container_view, fragment)
            ?.addToBackStack(null)
            ?.commit()
    }
}