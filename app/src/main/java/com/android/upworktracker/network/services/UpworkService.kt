package com.android.upworktracker.network.services

import com.android.upworktracker.entity.TrackerRequest
import com.android.upworktracker.entity.TrackerResponse
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.POST


interface UpworkService {
    @POST("tracker/orders")
    fun post(@Body body: TrackerRequest): Single<MutableList<TrackerResponse>>
}