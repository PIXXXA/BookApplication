package com.example.bookapplication.ui.fragment.bookdetails

import android.content.Context
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.bookapplication.R
import com.example.bookapplication.VOLUME_ID
import com.example.bookapplication.databinding.FragmentBookDetailsBinding
import com.squareup.picasso.Picasso
import org.koin.androidx.viewmodel.ext.android.viewModel


class BookDetailsFragment : Fragment() {

    private val viewModel by viewModel<BookDetailsViewModel>()
    private lateinit var binding: FragmentBookDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_book_details, container, false
        )
        binding.lifecycleOwner = this
        binding.viewModel = this.viewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        subscribe()
        binding.bookDetailsDescription.movementMethod = ScrollingMovementMethod()
    }

    private fun subscribe() {
        viewModel.imageLinks.observe(viewLifecycleOwner, {
            Picasso.get().load(it).into(binding.detailsBookView)
        })
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        arguments?.getString(VOLUME_ID)?.let {
            viewModel.getBookDetails(it)
        }
    }
}