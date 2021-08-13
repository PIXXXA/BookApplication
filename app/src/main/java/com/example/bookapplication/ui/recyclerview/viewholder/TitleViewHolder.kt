package com.example.bookapplication.ui.recyclerview.viewholder

import com.example.bookapplication.databinding.RecyclerViewTitleItemBinding
import com.example.bookapplication.models.recyclermodel.RecyclerListModel

class TitleViewHolder(private val binding: RecyclerViewTitleItemBinding) :
    BaseViewHolder(binding.root) {

    override fun populate(model: RecyclerListModel) {
        if (model is RecyclerListModel.TitleItem) {
            binding.titleItem.text = model.title
        }
    }
}