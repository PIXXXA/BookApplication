package com.example.bookapplication.ui.recyclerview.viewholder

import android.view.View
import com.example.bookapplication.R
import com.example.bookapplication.databinding.CatalogViewBinding
import com.example.bookapplication.models.catalogmodel.Item
import com.example.bookapplication.ui.view.SectionView

class FreeCatalogViewHolder(private val binding: CatalogViewBinding) :
    CatalogViewHolder(binding.root) {

    override fun populate(model: List<Item>) {
        binding.root.removeAllViews()
        binding.catalogDivider.visibility = View.GONE
        model.forEachIndexed { index, _ ->
            if (index == 0) {
                binding.catalogTitle.text = binding.root.context.getText(R.string.free_books_title)
            }
            val freeCatalogView = SectionView(itemView.context)
            freeCatalogView.setSectionIcon(model[index].volumeInfo.imageLinks.thumbnail)
            freeCatalogView.setSectionTitle(model[index].volumeInfo.title)
            binding.catalogContainer.addView(freeCatalogView)
        }
    }
}