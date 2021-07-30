package com.example.bookapplication.activity

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import androidx.fragment.app.Fragment
import com.example.bookapplication.R
import com.example.bookapplication.fragment.freecatalog.FreeCatalogOfBooks
import com.example.bookapplication.fragment.paidcatalog.PaidCatalogOfBooks
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onCreateView(name: String, context: Context, attrs: AttributeSet): View? {
        initFragmentContainer(R.id.free_books_view, FreeCatalogOfBooks())
        initFragmentContainer(R.id.paid_books_view, PaidCatalogOfBooks())
        return super.onCreateView(name, context, attrs)
    }

    private fun initFragmentContainer(viewId: Int, fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(viewId, fragment).commit()
    }
}