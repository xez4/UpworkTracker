package com.android.upworktracker


import com.google.gson.annotations.SerializedName

data class Response(
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
    @SerializedName("_id")
    val id: String,
    @SerializedName("link")
    val link: String,
    @SerializedName("location")
    val location: String,
    @SerializedName("skills")
    val skills: List<String>,
    @SerializedName("title")
    val title: String
)