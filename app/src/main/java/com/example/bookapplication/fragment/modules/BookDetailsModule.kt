package com.example.bookapplication.fragment.modules

import com.example.bookapplication.fragment.bookdetails.BookDetailsViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

fun createBookDetailsModule(): List<Module> {

    val viewModel = module {
        viewModel { BookDetailsViewModel() }
    }
    return arrayListOf(viewModel)
}