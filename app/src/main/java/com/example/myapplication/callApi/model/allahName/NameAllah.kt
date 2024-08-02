package com.example.myapplication.callApi.model.allahName

import com.google.gson.annotations.SerializedName

data class NameAllah(
    @SerializedName("code") val code: Int,
    @SerializedName("status") val status: String,
    @SerializedName("data") val data: List<DataNameAllah>
)
