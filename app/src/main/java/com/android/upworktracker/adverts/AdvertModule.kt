package com.android.upworktracker.adverts

import org.koin.dsl.module

val advertsModule = module {
    factory { AdvertPresenter(get()) }
}