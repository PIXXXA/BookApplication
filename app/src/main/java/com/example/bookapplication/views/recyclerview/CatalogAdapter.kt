package com.example.bookapplication.views.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bookapplication.databinding.RecyclerViewItemBinding
import com.example.bookapplication.models.catalogmodel.Item
import com.squareup.picasso.Picasso

class CatalogAdapter(private val model: List<Item>, private val callback: IRecyclerViewCallback) :
    RecyclerView.Adapter<CatalogAdapter.CatalogViewHolder>() {

    inner class CatalogViewHolder(val binding: RecyclerViewItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatalogViewHolder {
        val binding =
            RecyclerViewItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CatalogViewHolder(binding)
    }

    override fun getItemCount(): Int = model.size

    override fun onBindViewHolder(holder: CatalogViewHolder, position: Int) {
        Picasso.get().load(model[position].volumeInfo.imageLinks.thumbnail)
            .into(holder.binding.bookImage)
        holder.binding.bookTitle.text = model[position].volumeInfo.title
        onClick(holder, model[position].id)
    }

    private fun onClick(holder: CatalogViewHolder, bookId: String) {
        holder.itemView.setOnClickListener {
            callback.onClickListener(bookId)
        }
    }
}
