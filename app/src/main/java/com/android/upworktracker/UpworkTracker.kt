package com.android.upworktracker

import android.app.Application
import android.util.Log
import com.android.upworktracker.adverts.advertsModule
import com.android.upworktracker.bottom_sheet.category.categoryModule
import com.android.upworktracker.bottom_sheet.filter.filterModule
import com.android.upworktracker.di.networkModule
import com.android.upworktracker.di.repositoryModule
import com.android.upworktracker.di.sharedPreferencesModule
import com.android.upworktracker.intro.introModule
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.iid.FirebaseInstanceId
import com.google.firebase.messaging.FirebaseMessaging
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class UpworkTracker : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@UpworkTracker)
            modules(listOf(
                    introModule,
                    advertsModule,
                    networkModule,
                    sharedPreferencesModule,
                    categoryModule,
                    filterModule,
                    repositoryModule
            ))
        }
        FirebaseMessaging.getInstance().isAutoInitEnabled = true
        FirebaseInstanceId.getInstance().instanceId
            .addOnCompleteListener(OnCompleteListener { task ->
                if (!task.isSuccessful) {
                    Log.w(TAG, "getInstanceId failed", task.exception)
                    return@OnCompleteListener
                }
                val token = task.result?.token

                val msg = getString(R.string.msg_token_fmt, token)
                Log.d(TAG, msg)
            })
    }

    companion object {
        private const val TAG = "MainActivity"
    }

}
