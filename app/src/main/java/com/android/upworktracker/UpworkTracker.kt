package com.android.upworktracker

import android.app.Application
import com.android.upworktracker.intro.introModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class UpworkTracker:Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@UpworkTracker)
            modules(listOf(introModule))
        }
    }
}