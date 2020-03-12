package com.android.upworktracker.di

import com.android.upworktracker.bottom_sheet.Repository
import org.koin.dsl.module

val repositoryModule = module {
    single { Repository(get()) }
}