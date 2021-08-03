package com.example.bookapplication.modules

import com.example.bookapplication.views.fragment.bookdetails.BookDetailsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

fun createBookDetailsModule(): List<Module> {

    val viewModel = module {
        viewModel { BookDetailsViewModel(get(), get()) }
    }
    return arrayListOf(viewModel)
}