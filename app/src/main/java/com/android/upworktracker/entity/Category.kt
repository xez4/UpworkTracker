package com.android.upworktracker.entity


import com.google.gson.annotations.SerializedName

data class Category(
        @SerializedName("title_category")
        val titleCategory: String,
        @SerializedName("description")
        val description: List<Description>,
        var checkedState: Boolean = false
)