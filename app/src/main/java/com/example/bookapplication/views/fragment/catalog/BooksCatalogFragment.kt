package com.example.bookapplication.views.fragment.catalog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bookapplication.R
import com.example.bookapplication.databinding.FragmentBooksCatalogBinding
import com.example.bookapplication.models.catalogmodel.Item
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
        binding = DataBindingUtil.inflate<FragmentBooksCatalogBinding>(
            inflater, R.layout.fragment_books_catalog, container, false
        ).apply {
            lifecycleOwner = this@BooksCatalogFragment
            viewModel = this@BooksCatalogFragment.viewModel
            arguments
        }
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
            configAdapter(binding.paidBooksRecyclerView, FIELD_PAID, list)
            configAdapter(binding.freeBookRecyclerView, FIELD_FREE, list)
        })
    }

    private fun configAdapter(recyclerView: RecyclerView, price: String, catalog: List<Item>) {
        recyclerView.adapter =
            CatalogAdapter(
                catalog.filter { item -> item.saleInfo.saleability == price },
                this
            )
    }

    private fun createRecyclerViews() {
        viewModel.catalog.observe(viewLifecycleOwner, {
            binding.freeBookRecyclerView.layoutManager = GridLayoutManager(this.context, 2)
            binding.paidBooksRecyclerView.layoutManager = GridLayoutManager(this.context, 2)
        })
    }

    private fun initListeners() {
        binding.searchButton.setOnClickListener {
            viewModel.getBooksCatalog(binding.searchEditText.text.toString())
        }
    }

    companion object {

        const val FIELD_FREE = "FREE"
        const val FIELD_PAID = "PAID"
    }

    override fun onClickListener() {
        val transaction = activity?.supportFragmentManager?.beginTransaction()
        transaction?.replace(R.id.fragment_container_view, BookDetailsFragment())
        transaction?.disallowAddToBackStack()
        transaction?.commit()
    }
}