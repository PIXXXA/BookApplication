package com.example.bookapplication.fragment.bookdetails

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.bookapplication.R
import com.example.bookapplication.fragment.catalog.BooksCatalogViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class BookDetailsFragment : Fragment() {

    private val viewModel by viewModel<BookDetailsViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_book_details, container, false)
    }
}