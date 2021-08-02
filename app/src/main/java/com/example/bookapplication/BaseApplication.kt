package com.example.bookapplication

import android.app.Application
import com.example.bookapplication.modules.createBookDetailsModule
import com.example.bookapplication.modules.createBooksCatalogModule
import com.example.bookapplication.modules.retrofitModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.component.KoinComponent
import org.koin.core.context.startKoin
import org.koin.core.module.Module

class BaseApplication : KoinComponent, Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin() {
        insertKoin(this, createModules())
    }

    private fun createModules(): List<Module> {
        val modules = arrayListOf<Module>()
        modules.addAll(createBooksCatalogModule())
        modules.addAll(createBookDetailsModule())
        modules.addAll(retrofitModule())
        return modules
    }

    private fun insertKoin(app: Application, moduleList: List<Module>) {
        startKoin {
            androidLogger()
            androidContext(app)
            modules(moduleList)
        }
    }
}