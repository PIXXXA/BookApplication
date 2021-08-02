package com.example.bookapplication.modules

import com.example.bookapplication.views.fragment.catalog.BooksCatalogViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

fun createBooksCatalogModule(): List<Module> {

    val viewModel = module {
        viewModel { BooksCatalogViewModel(get()) }
    }
    return arrayListOf(viewModel)
}