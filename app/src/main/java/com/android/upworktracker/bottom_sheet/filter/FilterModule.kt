package com.android.upworktracker.bottom_sheet.filter

import org.koin.dsl.module

val filterModule = module {
    factory { FilterPresenter(get(), get()) }
}