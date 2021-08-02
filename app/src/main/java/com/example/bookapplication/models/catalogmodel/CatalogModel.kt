package com.example.bookapplication.models.catalogmodel

import com.google.gson.annotations.SerializedName

data class CatalogModel(
    @SerializedName("items")
    val items: List<Item>,
    @SerializedName("kind")
    val kind: String,
    @SerializedName("totalItems")
    val totalItems: Int
)