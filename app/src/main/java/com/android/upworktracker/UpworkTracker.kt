package com.android.upworktracker

import android.app.Application
import com.android.upworktracker.adverts.advertsModule
import com.android.upworktracker.bottom_sheet.category.categoryModule
import com.android.upworktracker.bottom_sheet.filter.filterModule
import com.android.upworktracker.di.networkModule
import com.android.upworktracker.di.sharedPreferencesModule
import com.android.upworktracker.intro.introModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class UpworkTracker : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@UpworkTracker)
            modules(
                    listOf(
                            introModule,
                            advertsModule,
                            networkModule,
                            sharedPreferencesModule,
                            categoryModule,
                            filterModule
                    )
            )
        }
    }

}
