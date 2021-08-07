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
        sadf()
    }

    private fun createAdapters() {
        viewModel.catalog.observe(viewLifecycleOwner, { list ->
            list?.let {
                val adapter = CatalogAdapter(
                    list,
                    this
                )
                binding.bookCatalogRecyclerView.adapter = adapter
                adapter.notifyDataSetChanged()
            }
        })
    }

    private fun sadf() {
        viewModel.catalog.observe(viewLifecycleOwner, { list ->
            binding.bookCatalogRecyclerView.layoutManager = GridLayoutManager(this.context, 2)
            viewModel.progressState.value = false
        })
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

    companion object {

        const val FIELD_FREE = "FREE"
    }
}