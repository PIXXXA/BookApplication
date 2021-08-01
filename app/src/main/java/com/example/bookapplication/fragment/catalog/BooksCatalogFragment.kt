package com.example.bookapplication.fragment.catalog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.bookapplication.R
import com.example.bookapplication.databinding.FragmentBooksCatalogBinding
import com.example.bookapplication.fragment.recyclerview.CatalogAdapter
import kotlinx.android.synthetic.main.fragment_books_catalog.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class BooksCatalogFragment : Fragment() {

    private val viewModel by viewModel<BooksCatalogViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        createRecyclerViews()
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return DataBindingUtil.inflate<FragmentBooksCatalogBinding>(
            inflater, R.layout.fragment_books_catalog, container, false
        ).run {
            lifecycleOwner = this@BooksCatalogFragment
            viewModel = this@BooksCatalogFragment.viewModel
            arguments
            root
        }
    }

    private fun createRecyclerViews() {
        viewModel.catalogList.observe(viewLifecycleOwner, {
            free_book_recycler_view.layoutManager = GridLayoutManager(this.context, 2)
            free_book_recycler_view.adapter = CatalogAdapter(it.filter { free ->free.title == "paid" })

            paid_books_recycler_view.layoutManager = GridLayoutManager(this.context, 2)
            paid_books_recycler_view.adapter = CatalogAdapter(it.filter { paid->paid.title == "free" })
        })
    }
}