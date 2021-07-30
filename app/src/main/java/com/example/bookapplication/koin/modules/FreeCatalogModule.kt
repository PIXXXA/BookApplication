package com.example.bookapplication.koin.modules

import com.example.bookapplication.fragment.freecatalog.FreeCatalogOfBooksViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

fun createFreeCatalogModule(): List<Module> {

    val viewModel = module {
        viewModel { FreeCatalogOfBooksViewModel() }
    }
    return arrayListOf(viewModel)
}