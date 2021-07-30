package com.example.bookapplication

import android.app.Application
import com.example.bookapplication.koin.modules.createFreeCatalogModule
import com.example.bookapplication.koin.modules.createPaidCatalogModule
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
        modules.addAll(createFreeCatalogModule())
        modules.addAll(createPaidCatalogModule())
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