package com.example.bookapplication.views.recyclerview

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.bookapplication.models.catalogmodel.Item
import com.squareup.picasso.Picasso

class CatalogViewHolder(private val view: View, private val model: Item) :
    RecyclerView.ViewHolder(view) {

    fun populate() {
        Picasso.get().load(model.volumeInfo.imageLinks.smallThumbnail).into(view.b)
        view.boo.text = model.volumeInfo.title
    }
}