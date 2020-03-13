package com.android.upworktracker.network.services

import com.android.upworktracker.entity.DatabaseResponse
import io.reactivex.Single
import retrofit2.http.GET

interface RepositoryService {
    @GET("xez4/json-db/db")
    fun getRepositoryData(): Single<DatabaseResponse>
}