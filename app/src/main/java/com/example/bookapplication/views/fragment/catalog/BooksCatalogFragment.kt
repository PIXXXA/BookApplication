package com.example.bookapplication.views.fragment.catalog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.bookapplication.R
import com.example.bookapplication.VOLUME_ID
import com.example.bookapplication.databinding.FragmentBooksCatalogBinding
import com.example.bookapplication.hideKeyboard
import com.example.bookapplication.views.fragment.bookdetails.BookDetailsFragment
import com.example.bookapplication.views.recyclerview.CatalogAdapter
import com.example.bookapplication.views.recyclerview.IRecyclerViewCallback
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
        initListeners()
        createAdapters()
        createRecyclerViews()
    }

    private fun createAdapters() {
        viewModel.catalog.observe(viewLifecycleOwner, { list ->
            list?.let {
                binding.freeBookRecyclerView.adapter = CatalogAdapter(
                    list.filter { item -> item.saleInfo.saleability == FIELD_FREE },
                    this
                )
                binding.paidBooksRecyclerView.adapter = CatalogAdapter(
                    list.filter { item -> item.saleInfo.saleability != FIELD_FREE },
                    this
                )
            }
        })
    }

    private fun createRecyclerViews() {
        viewModel.catalog.observe(viewLifecycleOwner, {
            binding.freeBookRecyclerView.layoutManager = GridLayoutManager(this.context, 2)
            binding.paidBooksRecyclerView.layoutManager = GridLayoutManager(this.context, 2)
            binding.catalogView.visibility = View.VISIBLE
            viewModel.progressState.value = false
        })
    }

    private fun initListeners() {
        binding.searchButton.setOnClickListener {
            viewModel.progressState.value = true
            viewModel.getBooksCatalog(binding.searchEditText.text.toString())
            view?.hideKeyboard()
        }
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

    companion object {

        const val FIELD_FREE = "FREE"
    }
}