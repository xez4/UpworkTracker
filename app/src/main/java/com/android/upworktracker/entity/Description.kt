package com.android.upworktracker.entity


import com.google.gson.annotations.SerializedName

data class Description(
    @SerializedName("subtitle")
    val subtitle: String,
    val checkedState: Boolean = false
)