package com.example.bookapplication.models.catalogmodel

import com.google.gson.annotations.SerializedName

data class SaleInfo(
    @SerializedName("saleability")
    val saleability: Saleability
)
