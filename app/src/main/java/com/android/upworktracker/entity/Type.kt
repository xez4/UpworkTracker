package com.android.upworktracker.entity


import com.google.gson.annotations.SerializedName

data class Type(
        @SerializedName("name")
        val name: String,
        var checkedState: Boolean = false
)