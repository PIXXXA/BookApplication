package com.example.bookapplication.fragment.freecatalog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.bookapplication.R
import com.example.bookapplication.databinding.FragmentFreeCatalogOfBooksBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class FreeCatalogOfBooks : Fragment() {

    private val viewModel by viewModel<FreeCatalogOfBooksViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return DataBindingUtil.inflate<FragmentFreeCatalogOfBooksBinding>(
            inflater, R.layout.fragment_free_catalog_of_books, container, false
        ).run {
            lifecycleOwner = this@FreeCatalogOfBooks
            viewModel = this@FreeCatalogOfBooks.viewModel
            arguments
            root
        }
    }
}