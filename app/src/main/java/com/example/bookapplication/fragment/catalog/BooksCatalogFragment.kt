package com.example.bookapplication.fragment.catalog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.bookapplication.R
import com.example.bookapplication.databinding.FragmentBooksCatalogBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class BooksCatalogFragment : Fragment() {

    private val viewModel by viewModel<BooksCatalogViewModel>()

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
}