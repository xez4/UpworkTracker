package com.android.upworktracker.entity

import com.google.gson.annotations.SerializedName

data class DatabaseResponse(
    @SerializedName("results")
    val results: List<Result>
)