package com.android.upworktracker.di

import com.android.upworktracker.bottom_sheet.Repository
import com.android.upworktracker.bottom_sheet.RepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {
    single<Repository> { RepositoryImpl(get()) }
}