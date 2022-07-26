package com.vast.coroutines.data.di

import com.vast.coroutines.data.net.animals.AnimalService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {
    single { provideOkHttpClient() }
    single { provideRetrofit(get()) }
    single { provideAnimalService(get()) }
}

fun provideOkHttpClient(): OkHttpClient =
    OkHttpClient.Builder().apply {
        val logLevel = HttpLoggingInterceptor.Level.BODY
        addInterceptor(HttpLoggingInterceptor().setLevel(logLevel))
    }.build()

fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit =
    Retrofit.Builder().apply {
        baseUrl("https://zoo-animal-api.herokuapp.com")
        addConverterFactory(GsonConverterFactory.create())
        client(okHttpClient)
    }.build()

fun provideAnimalService(retrofit: Retrofit): AnimalService =
    retrofit.create(AnimalService::class.java)
