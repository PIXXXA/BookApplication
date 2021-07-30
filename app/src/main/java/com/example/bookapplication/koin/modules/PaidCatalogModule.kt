package com.example.bookapplication.koin.modules

import com.example.bookapplication.fragment.paidcatalog.PaidCatalogOfBooksViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

fun createPaidCatalogModule(): List<Module> {
    val viewModels = module {
        viewModel { PaidCatalogOfBooksViewModel() }
    }
    return arrayListOf(viewModels)
}