package com.example.bookapplication.ui.recyclerview.viewholder

import com.example.bookapplication.databinding.RecyclerViewDividerItemBinding
import com.example.bookapplication.models.recyclermodel.RecyclerListModel

class DividerViewHolder(private val itemView: RecyclerViewDividerItemBinding) :
    BaseViewHolder(itemView.root) {

    override fun populate(model: RecyclerListModel) {
        //do nothing
    }
}