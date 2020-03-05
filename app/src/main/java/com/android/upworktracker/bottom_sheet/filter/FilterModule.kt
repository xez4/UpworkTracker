package com.android.upworktracker.bottom_sheet.filter

import org.koin.dsl.module

val filterModule = module {
    single<FilterRepo> { FilterRepoImpl(get()) }
    factory { FilterPresenter(get(), get()) }
}