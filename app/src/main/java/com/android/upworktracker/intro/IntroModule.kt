package com.android.upworktracker.intro

import org.koin.dsl.module

val introModule = module {
    factory { IntroPresenter() }
}