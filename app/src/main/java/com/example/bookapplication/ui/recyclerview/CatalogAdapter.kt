package com.example.bookapplication.ui.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bookapplication.R
import com.example.bookapplication.databinding.CatalogViewBinding
import com.example.bookapplication.models.catalogmodel.Item
import com.example.bookapplication.models.catalogmodel.Saleability
import com.example.bookapplication.ui.recyclerview.callback.IRecyclerViewCallback
import com.example.bookapplication.ui.recyclerview.viewholder.CatalogViewHolder
import com.example.bookapplication.ui.recyclerview.viewholder.FreeCatalogViewHolder
import com.example.bookapplication.ui.recyclerview.viewholder.PaidCatalogViewHolder

class CatalogAdapter(private val model: List<Item>, private val callback: IRecyclerViewCallback) :
    RecyclerView.Adapter<CatalogViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatalogViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.catalog_view, parent, false)
        return when (viewType) {
            Saleability.FREE.ordinal -> {
                FreeCatalogViewHolder(
                    CatalogViewBinding.bind(view)
                )
            }
            else -> {
                PaidCatalogViewHolder(
                    CatalogViewBinding.bind(view)
                )
            }
        }
    }

    override fun getItemCount(): Int = model.size

    override fun getItemViewType(position: Int): Int =
        model[position].saleInfo.saleability.ordinal

    override fun onBindViewHolder(holder: CatalogViewHolder, position: Int) {
        holder.populate(getModel(holder))
        onClick(holder, model[position].id)
    }

    private fun getModel(holder: CatalogViewHolder): List<Item> {
        return if (holder is FreeCatalogViewHolder) {
            model.filter { item -> item.saleInfo.saleability == Saleability.FREE }
        } else {
            model.filter { item -> item.saleInfo.saleability != Saleability.FREE }
        }
    }

    private fun onClick(holder: CatalogViewHolder, bookId: String) {
        holder.itemView.setOnClickListener {
            callback.onClickListener(bookId)
        }
    }
}
