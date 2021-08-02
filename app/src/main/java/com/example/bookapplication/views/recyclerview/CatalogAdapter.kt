package com.example.bookapplication.views.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bookapplication.R
import com.example.bookapplication.models.catalogmodel.Item

class CatalogAdapter(private val model: List<Item>, private val callback: IRecyclerViewCallback) :
    RecyclerView.Adapter<CatalogViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatalogViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_view_item, parent, false)
        return CatalogViewHolder(view, model[viewType])
    }

    override fun getItemCount(): Int = model.size

    override fun onBindViewHolder(holder: CatalogViewHolder, position: Int) {
        holder.populate()
        onClick(holder)
    }

    private fun onClick(holder: CatalogViewHolder) {
        holder.itemView.setOnClickListener {
            callback.onClickListener()
        }
    }
}
