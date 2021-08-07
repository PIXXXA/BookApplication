package com.example.bookapplication.ui.recyclerview.viewholder

import android.view.View
import com.example.bookapplication.R
import com.example.bookapplication.databinding.CatalogViewBinding
import com.example.bookapplication.models.catalogmodel.Item
import com.example.bookapplication.ui.view.SectionView

class PaidCatalogViewHolder(private val binding: CatalogViewBinding) :
    CatalogViewHolder(binding.root) {

    override fun populate(model: List<Item>) {
        binding.root.removeAllViews()
        binding.catalogDivider.visibility = View.VISIBLE
        binding.catalogTitle.text = binding.root.context.getText(R.string.paid_books_title)
        model.forEachIndexed { index, _ ->
            val paidCatalogView = SectionView(binding.root.context)
            paidCatalogView.setSectionIcon(model[index].volumeInfo.imageLinks.thumbnail)
            paidCatalogView.setSectionTitle(model[index].volumeInfo.title)
            binding.catalogContainer.addView(paidCatalogView)
        }
    }
}