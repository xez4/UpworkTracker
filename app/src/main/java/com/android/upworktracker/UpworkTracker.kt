package com.android.upworktracker

import android.app.Application
import com.android.upworktracker.adverts.advertsModule
import com.android.upworktracker.di.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import com.android.upworktracker.intro.introModule

class UpworkTracker : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@UpworkTracker)
            modules(listOf(introModule, advertsModule, networkModule))
        }
    }
}
