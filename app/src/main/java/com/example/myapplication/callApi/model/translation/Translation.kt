package com.example.myapplication.callApi.model.translation

import com.google.gson.annotations.SerializedName

data class Translation(
    @SerializedName("code") val code: Int,
    @SerializedName("status") val status: String,
    @SerializedName("data") val data: Data

)
