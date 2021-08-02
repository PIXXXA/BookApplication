package com.example.bookapplication.restapi

import com.example.bookapplication.models.catalogmodel.CatalogModel
import com.example.bookapplication.models.detailsmodel.DetailsModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface IServiceApi {

    @GET(value = "volumes")
    fun searchTheBook(
        @Query(value = "q") q: String,
        @Query(value = "filter") filter: String
    ): Call<CatalogModel>

    @GET(value = "volumes/{volumeId}")
    fun getCurrentBook(@Path(value = "volumeId") volumeId: String): Call<DetailsModel>
}