package com.example.bookapplication.views.fragment.bookdetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.bookapplication.R
import com.example.bookapplication.VOLUME_ID
import com.example.bookapplication.databinding.FragmentBookDetailsBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class BookDetailsFragment : Fragment() {

    private val viewModel by viewModel<BookDetailsViewModel>()
    private lateinit var binding: FragmentBookDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate<FragmentBookDetailsBinding>(
            inflater, R.layout.fragment_book_details, container, false
        ).apply {
            lifecycleOwner = this@BookDetailsFragment
            viewModel = this@BookDetailsFragment.viewModel
            arguments
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getDataFromRequest(savedInstanceState?.getString(VOLUME_ID).toString())
    }

    private fun getDataFromRequest(volumeId: String) {
        binding.detailsProgressBar.visibility = View.VISIBLE
        viewModel.getBookDetails(volumeId)
        binding.detailsProgressBar.visibility = View.GONE

    }
}