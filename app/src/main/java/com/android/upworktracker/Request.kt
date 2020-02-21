package com.android.upworktracker


import com.google.gson.annotations.SerializedName

data class Request(
    @SerializedName("api_params")
    val apiParams: String="",
    @SerializedName("budget")
    val budget: String="",
    @SerializedName("client_hires")
    val clientHires: String="",
    @SerializedName("contractor_tier")
    val contractorTier: String="",
    @SerializedName("duration_v3")
    val durationV3: String="",
    @SerializedName("job_type")
    val jobType: String="",
    @SerializedName("paging")
    val paging: String="0%3B10",
    @SerializedName("proposals")
    val proposals: String="",
    @SerializedName("q")
    val q: String="",
    @SerializedName("sort")
    val sort: String="",
    @SerializedName("verified_payment_only")
    val verifiedPaymentOnly: String="",
    @SerializedName("workload")
    val workload: String=""
)