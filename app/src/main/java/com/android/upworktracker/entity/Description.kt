package com.android.upworktracker.entity


import com.google.gson.annotations.SerializedName

data class Description(
        @SerializedName("subtitle")
        val subtitle: String,
        var checkedState: Boolean = false
)