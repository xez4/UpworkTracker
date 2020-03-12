package com.android.upworktracker.di

import com.android.upworktracker.network.services.RepositoryService
import com.android.upworktracker.network.services.UpworkService
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {
    single { provideRetrofit() }
    single { provideRepositoryRetrofit() }
}

fun provideRetrofit(): UpworkService = Retrofit.Builder()
        .baseUrl("https://upwork-tracker.herokuapp.com/api/")
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
        .create(UpworkService::class.java)

fun provideRepositoryRetrofit(): RepositoryService = Retrofit.Builder()
        .baseUrl("https://my-json-server.typicode.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
        .create(RepositoryService::class.java)