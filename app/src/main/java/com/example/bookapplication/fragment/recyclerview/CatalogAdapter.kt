package com.example.bookapplication.fragment.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bookapplication.R
import com.example.bookapplication.fragment.catalog.BooksCatalogModel

class CatalogAdapter(private val model: List<BooksCatalogModel>) :
    RecyclerView.Adapter<CatalogViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatalogViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_view_item, parent, false)
        return CatalogViewHolder(view)
    }

    override fun getItemCount(): Int = model.size

    override fun onBindViewHolder(holder: CatalogViewHolder, position: Int) {
        holder.populate(model[position])
    }
}
