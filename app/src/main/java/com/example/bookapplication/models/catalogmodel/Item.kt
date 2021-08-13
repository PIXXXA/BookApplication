package com.example.bookapplication.models.catalogmodel

import com.google.gson.annotations.SerializedName

data class Item(
    @SerializedName("id")
    val id: String,
    @SerializedName("saleInfo")
    val saleInfo: SaleInfo,
    @SerializedName("volumeInfo")
    val volumeInfo: VolumeInfo
)