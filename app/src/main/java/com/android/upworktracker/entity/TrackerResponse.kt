package com.android.upworktracker.entity

import com.google.gson.annotations.SerializedName

data class TrackerResponse(
        @SerializedName("budget")
        val budget: String,
        @SerializedName("category")
        val category: String,
        @SerializedName("country")
        val country: String,
        @SerializedName("date")
        val date: String,
        @SerializedName("description")
        val description: String,
        @SerializedName("location")
        val location: String,
        @SerializedName("skills")
        val skills: MutableList<String>?,
        @SerializedName("title")
        val title: String,
        @SerializedName("link")
        val link: String
)