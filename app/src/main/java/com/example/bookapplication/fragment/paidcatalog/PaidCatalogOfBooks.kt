package com.example.bookapplication.fragment.paidcatalog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.bookapplication.R
import com.example.bookapplication.databinding.FragmentPaidCatalogOfBooksBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class PaidCatalogOfBooks : Fragment() {

    private val viewModel by viewModel<PaidCatalogOfBooksViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return DataBindingUtil.inflate<FragmentPaidCatalogOfBooksBinding>(
            inflater, R.layout.fragment_paid_catalog_of_books, container, false
        ).run {
            lifecycleOwner = this@PaidCatalogOfBooks
            viewModel = this@PaidCatalogOfBooks.viewModel
            arguments
            root
        }
    }
}