package com.android.upworktracker.network.services

import com.android.upworktracker.entity.TrackerPushRequest
import io.reactivex.Completable
import retrofit2.http.Body
import retrofit2.http.POST

interface PushService {
    @POST("tracker/orders")
    fun postPush(@Body body: TrackerPushRequest): Completable
}