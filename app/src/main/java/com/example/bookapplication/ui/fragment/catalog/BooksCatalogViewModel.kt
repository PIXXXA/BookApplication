package com.example.bookapplication.ui.fragment.catalog

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.bookapplication.models.catalogmodel.CatalogModel
import com.example.bookapplication.models.catalogmodel.Item
import com.example.bookapplication.restapi.IServiceApi
import org.koin.core.component.KoinComponent
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BooksCatalogViewModel(private val apiService: IServiceApi) :
    ViewModel(), KoinComponent {

    private val _catalog = MutableLiveData<List<Item>?>()
    val catalog: LiveData<List<Item>?> = _catalog
    val progressState = MutableLiveData<Boolean>()

    init {
        progressState.value = false
    }

    fun getBooksCatalog(searchText: String) {
        val catalog = apiService.searchTheBook(searchText, FILTER)
        catalog.enqueue(object : Callback<CatalogModel> {
            override fun onResponse(
                call: Call<CatalogModel>,
                response: Response<CatalogModel>
            ) {
                if (response.isSuccessful) {
                    _catalog.value = response.body()?.items
                }
            }

            override fun onFailure(call: Call<CatalogModel>, t: Throwable) {
                t.message?.let { Log.d(CATALOG_ERROR, it) }
            }
        })
    }

    companion object {

        const val FILTER = "ebooks"
        const val CATALOG_ERROR = "error"
    }
}