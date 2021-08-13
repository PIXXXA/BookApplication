package com.example.bookapplication.ui.recyclerview.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.bookapplication.models.recyclermodel.RecyclerListModel

abstract class BaseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    abstract fun populate(model: RecyclerListModel)
}