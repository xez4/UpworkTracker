package com.android.upworktracker.entity


import com.google.gson.annotations.SerializedName

data class Filter(
        @SerializedName("title_filter")
        val titleFilter: String,
        @SerializedName("type")
        val type: List<Type>
)