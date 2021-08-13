package com.example.bookapplication.models.catalogmodel

import com.google.gson.annotations.SerializedName

data class VolumeInfo(
    @SerializedName("description")
    val description: String,
    @SerializedName("imageLinks")
    val imageLinks: ImageLinks,
    @SerializedName("subtitle")
    val subtitle: String,
    @SerializedName("title")
    val title: String
)