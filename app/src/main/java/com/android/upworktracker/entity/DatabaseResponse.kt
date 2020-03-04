package com.android.upworktracker.entity


import com.google.gson.annotations.SerializedName

data class DatabaseResponse(
    @SerializedName("category")
    val category: List<Category>,
    @SerializedName("filter")
    val filter: List<Filter>
)