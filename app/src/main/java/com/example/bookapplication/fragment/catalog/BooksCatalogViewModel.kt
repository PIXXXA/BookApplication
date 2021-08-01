package com.example.bookapplication.fragment.catalog

import android.content.res.Resources
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.bookapplication.restapi.IServiceApi
import org.koin.core.component.KoinComponent

class BooksCatalogViewModel(val apiService: IServiceApi, val resources: Resources) : ViewModel(),
    KoinComponent {

    private val _catalogList = MutableLiveData<List<BooksCatalogModel>>()
    val catalogList: LiveData<List<BooksCatalogModel>> = _catalogList

    fun getBooksCatalog(searchText: String) {

    }

}