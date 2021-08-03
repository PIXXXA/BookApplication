package com.example.bookapplication.views.fragment.bookdetails

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.bookapplication.R
import com.example.bookapplication.models.detailsmodel.DetailsModel
import com.example.bookapplication.restapi.IServiceApi
import org.koin.core.component.KoinComponent
import retrofit2.Call
import retrofit2.Response

class BookDetailsViewModel(private val apiService: IServiceApi, private val context: Context) :
    ViewModel(), KoinComponent {

    private val _title = MutableLiveData<String>()
    val title: LiveData<String> = _title

    private val _subtitle = MutableLiveData<String>()
    val subtitle: LiveData<String> = _subtitle

    private val _description = MutableLiveData<String>()
    val description: LiveData<String> = _description

    private val _imageLinks = MutableLiveData<String>()
    val imageLinks: LiveData<String> = _imageLinks

    fun getBookDetails(volumeId: String) {
        val bookDetails = volumeId.let { apiService.getCurrentBook(it) }
        bookDetails.enqueue(object : retrofit2.Callback<DetailsModel> {
            override fun onResponse(call: Call<DetailsModel>, response: Response<DetailsModel>) {
                response.body()?.let { getDetailsData(it) }
            }

            override fun onFailure(call: Call<DetailsModel>, t: Throwable) {
                t.message?.let { Log.d(TAG, it) }
            }

        })
    }

    private fun getDetailsData(model: DetailsModel) {
        _title.value = model.volumeInfo.title
        _subtitle.value = model.volumeInfo.subtitle
        _description.value = model.volumeInfo.description
            ?: context.getString(R.string.book_details_descruption_null)
        _imageLinks.value = model.volumeInfo.imageLinks.thumbnail
    }

    companion object {
        const val TAG = "book details"
    }
}