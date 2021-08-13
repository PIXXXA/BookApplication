package com.example.bookapplication.ui.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bookapplication.R
import com.example.bookapplication.databinding.RecyclerViewBookItemBinding
import com.example.bookapplication.databinding.RecyclerViewDividerItemBinding
import com.example.bookapplication.databinding.RecyclerViewTitleItemBinding
import com.example.bookapplication.models.recyclermodel.RecyclerListModel
import com.example.bookapplication.ui.recyclerview.callback.IRecyclerViewCallback
import com.example.bookapplication.ui.recyclerview.viewholder.BaseViewHolder
import com.example.bookapplication.ui.recyclerview.viewholder.BookViewHolder
import com.example.bookapplication.ui.recyclerview.viewholder.DividerViewHolder
import com.example.bookapplication.ui.recyclerview.viewholder.TitleViewHolder

class CatalogAdapter(
    private val model: List<RecyclerListModel>,
    private val callback: IRecyclerViewCallback
) : RecyclerView.Adapter<BaseViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return when (viewType) {
            0 -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.recycler_view_book_item, parent, false)
                BookViewHolder(RecyclerViewBookItemBinding.bind(view))
            }
            1 -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.recycler_view_title_item, parent, false)
                TitleViewHolder(RecyclerViewTitleItemBinding.bind(view))
            }
            else -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.recycler_view_book_item, parent, false)
                DividerViewHolder(RecyclerViewDividerItemBinding.bind(view))
            }
        }
    }

    override fun getItemCount(): Int = model.size

    override fun getItemViewType(position: Int): Int {
        return when (model[position]) {
            is RecyclerListModel.BookItem -> 0
            is RecyclerListModel.TitleItem -> 1
            is RecyclerListModel.DividerItem -> 2
        }
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        holder.populate(model[position])
    }

//    private fun onClick(holder: BookViewHolder, bookId: String) {
//        holder.itemView.setOnClickListener {
//            callback.onClickListener(bookId)
//        }
//    }
}