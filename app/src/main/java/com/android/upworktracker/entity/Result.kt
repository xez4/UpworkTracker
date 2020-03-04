package com.android.upworktracker.entity

import com.google.gson.annotations.SerializedName

data class Result(
    @SerializedName("title")
    val title: String,
    @SerializedName("description")
    val description: List<Description>
)