package com.example.bookapplication.activity

import android.content.Context
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.bookapplication.R
import com.example.bookapplication.fragment.catalog.BooksCatalogFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onCreateView(name: String, context: Context, attrs: AttributeSet): View? {
        supportFragmentManager.beginTransaction().replace(R.id.free_books_view, BooksCatalogFragment()).commit()
        return super.onCreateView(name, context, attrs)
    }
}