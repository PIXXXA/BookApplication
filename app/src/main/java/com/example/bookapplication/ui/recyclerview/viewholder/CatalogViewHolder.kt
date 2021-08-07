package com.example.bookapplication.ui.recyclerview.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.bookapplication.models.catalogmodel.Item

abstract class CatalogViewHolder(private val view: View) :
    RecyclerView.ViewHolder(view) {
    abstract fun populate(model: List<Item>)
}