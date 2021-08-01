package com.example.bookapplication.restapi

import com.example.bookapplication.fragment.bookdetails.BookDetailsModel
import com.example.bookapplication.fragment.catalog.BooksCatalogModel
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface IServiceApi {

    @GET(value = "/volumes")
    suspend fun searchTheBook(@Query(value = "q") q: String): BooksCatalogModel

    @GET(value = "/volumes/{volumeId}")
    suspend fun getCurrentBook(@Path(value = "volumeId") apiKey: String): BookDetailsModel
}