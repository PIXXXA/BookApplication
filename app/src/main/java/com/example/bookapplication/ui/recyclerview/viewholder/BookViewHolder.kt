package com.example.bookapplication.ui.recyclerview.viewholder

import com.example.bookapplication.databinding.RecyclerViewBookItemBinding
import com.example.bookapplication.models.recyclermodel.RecyclerListModel
import com.squareup.picasso.Picasso

class BookViewHolder(
    private val binding: RecyclerViewBookItemBinding
) : BaseViewHolder(binding.root) {

    override fun populate(model: RecyclerListModel) {
        if (model is RecyclerListModel.BookItem) {
            Picasso.get().load(model.icon)
                .into(binding.catalogBookImage)
            binding.catalogBookTitle.text = model.title
        }
    }
}