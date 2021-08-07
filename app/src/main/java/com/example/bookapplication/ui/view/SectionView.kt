package com.example.bookapplication.ui.view

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import com.example.bookapplication.R
import com.example.bookapplication.databinding.RecyclerViewItemBinding
import com.squareup.picasso.Picasso

class SectionView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : BaseSectionView(context, attrs, defStyleAttr) {

    private lateinit var iconImageView: AppCompatImageView

    override fun findViews() {
        val inflater: LayoutInflater = LayoutInflater.from(context)
        val binding: RecyclerViewItemBinding = RecyclerViewItemBinding.inflate(inflater, this, true)
        binding.apply {
            iconImageView = catalogBookImage
            titledTextView = catalogBookTitle
        }
    }

    override fun findAttributes(attrs: AttributeSet, defStyleAttr: Int) {
        lateinit var typedArray: TypedArray
        try {
            typedArray = context.obtainStyledAttributes(
                attrs,
                R.styleable.SectionView,
                defStyleAttr,
                0
            )

            baseSectionViewTitle =
                typedArray.getString(R.styleable.SectionView_section_view_title)
                    ?: ""
        } finally {
            typedArray.recycle()
        }
    }

    fun setSectionIcon(iconUrl: String) {
        Picasso.get().load(iconUrl).into(iconImageView)
    }

    fun setSectionTitle(value: String) {
        titledTextView.text = value
    }

    companion object {
        @BindingAdapter("app:selectableTitledViewIcon")
        @JvmStatic
        fun setSelectableTitledViewIcon(
            view: SectionView, url: String?
        ) {
            url.let {
                Picasso.get().load(it).into(view.iconImageView)
            }
        }

        @BindingAdapter("app:selectableTitledViewTitle")
        @JvmStatic
        fun setSelectableTitledViewTitle(
            view: SectionView,
            title: String?
        ) {
            title?.let {
                view.titledTextView.text = title
            }
        }
    }
}