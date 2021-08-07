package com.example.bookapplication.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.bookapplication.R
import com.example.bookapplication.ui.fragment.catalog.BooksCatalogFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container_view, BooksCatalogFragment()).commit()
    }
}