package com.example.bookapplication.ui.view

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import androidx.appcompat.widget.AppCompatTextView

abstract class BaseSectionView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    init {
        this.findViews()
        attrs?.let { findAttributes(attrs, defStyleAttr) }
    }

    protected lateinit var titledTextView: AppCompatTextView

    var baseSectionViewTitle: String = ""
        set(value) {
            field = value
            titledTextView.text = field
        }

    abstract fun findViews()

    abstract fun findAttributes(attrs: AttributeSet, defStyleAttr: Int)
}