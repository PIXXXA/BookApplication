package com.example.bookapplication.fragment.modules

import com.example.bookapplication.BuildConfig.SERVER_URL
import com.example.bookapplication.restapi.IServiceApi
import okhttp3.OkHttpClient
import org.koin.android.BuildConfig
import org.koin.core.module.Module
import org.koin.dsl.module
import retrofit2.Retrofit

fun retrofitModule(): List<Module> {

    val module = module {
        single {
            okHttp()
        }
        single {
            retrofit()
        }
        single {
            get<Retrofit>().create(IServiceApi::class.java)
        }
    }
    return arrayListOf(module)
}

private fun okHttp() = OkHttpClient.Builder().build()

private fun retrofit() = Retrofit.Builder()
    .callFactory(OkHttpClient.Builder().build())
    .baseUrl(SERVER_URL)
    .build()