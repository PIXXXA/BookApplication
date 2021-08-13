package com.example.bookapplication.models.recyclermodel

sealed class RecyclerListModel {

    data class BookItem(val title: String, val icon: String, val id: String) : RecyclerListModel()

    class DividerItem : RecyclerListModel()

    data class TitleItem(val title: String) : RecyclerListModel()
}
