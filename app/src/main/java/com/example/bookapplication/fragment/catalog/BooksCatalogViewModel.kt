package com.example.bookapplication.fragment.catalog

import android.content.res.Resources
import androidx.lifecycle.ViewModel
import com.example.bookapplication.restapi.IServiceApi
import org.koin.core.KoinApplication
import org.koin.core.component.KoinComponent
import retrofit2.Retrofit

class BooksCatalogViewModel(val apiService: IServiceApi, val resources : Resources) : ViewModel(), KoinComponent {

}