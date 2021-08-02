package com.example.bookapplication.models.catalogmodel

import com.google.gson.annotations.SerializedName

data class Item(
    @SerializedName("accessInfo")
    val accessInfo: AccessInfo,
    @SerializedName("id")
    val id: String,
    @SerializedName("kind")
    val kind: String,
    @SerializedName("saleInfo")
    val saleInfo: SaleInfo,
    @SerializedName("searchInfo")
    val searchInfo: SearchInfo,
    @SerializedName("selfLink")
    val selfLink: String,
    @SerializedName("volumeInfo")
    val volumeInfo: VolumeInfo
)