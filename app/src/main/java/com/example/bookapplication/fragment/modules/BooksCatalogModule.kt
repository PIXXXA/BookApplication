package com.example.bookapplication.fragment.modules

import com.example.bookapplication.fragment.catalog.BooksCatalogViewModel
import com.example.bookapplication.restapi.IServiceApi
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

fun createBooksCatalogModule(): List<Module> {

    val viewModel = module {
        viewModel { BooksCatalogViewModel(get(), get()) }
    }
    return arrayListOf(viewModel)
}