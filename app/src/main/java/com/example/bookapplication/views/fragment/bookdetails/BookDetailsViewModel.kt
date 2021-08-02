package com.example.bookapplication.views.fragment.bookdetails

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.bookapplication.models.detailsmodel.DetailsModel
import com.example.bookapplication.restapi.IServiceApi
import org.koin.core.component.KoinComponent
import retrofit2.Call
import retrofit2.Response

class BookDetailsViewModel(private val apiService: IServiceApi) : ViewModel(), KoinComponent {

    private val _title = MutableLiveData<String>()
    val title: LiveData<String> = _title

    private val _price = MutableLiveData<String>()
    val price: LiveData<String> = _price

    private val _description = MutableLiveData<String>()
    val description: LiveData<String> = _description

    fun getBookDetails(volumeId: String) {
        val bookDetails = volumeId.let { apiService.getCurrentBook(it) }
        bookDetails.enqueue(object : retrofit2.Callback<DetailsModel> {
            override fun onResponse(call: Call<DetailsModel>, response: Response<DetailsModel>) {
                _title.value = response.body()?.volumeInfo?.title
                _price.value = response.body()?.saleInfo?.listPrice?.amount.toString()
                _description.value = response.body()?.volumeInfo?.description
            }

            override fun onFailure(call: Call<DetailsModel>, t: Throwable) {
                t.message?.let { Log.d(TAG, it) }
            }

        })
    }

    companion object {
        const val TAG = "book details"
    }
}