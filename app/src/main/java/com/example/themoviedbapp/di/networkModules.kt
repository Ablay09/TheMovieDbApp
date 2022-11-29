package com.example.themoviedbapp.di

import com.example.themoviedbapp.BuildConfig
import com.example.themoviedbapp.BuildConfig.BASE_URL
import com.example.themoviedbapp.core.network.NetworkConstants.REQUEST_TIMEOUT
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import okhttp3.OkHttpClient
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit

const val BASE_API = "base_api"

@ExperimentalSerializationApi
val networkModule = module {
    single {
        OkHttpClient.Builder()
            .readTimeout(REQUEST_TIMEOUT, TimeUnit.MILLISECONDS)
            .build()
    }

    single(named(BASE_API)) {
        val mediaType = MediaType.get("application/json")
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(Json.asConverterFactory(mediaType))
    }
}