package com.android.upworktracker.bottom_sheet.category

import org.koin.dsl.module

val categoryModule = module {
    factory { CategoryPresenter(get()) }
}