package com.example.myapplication.callApi.model.original

import com.example.myapplication.callApi.model.allahName.DataNameAllah
import com.google.gson.annotations.SerializedName

data class Original(
    @SerializedName("code") val code: Int,
    @SerializedName("status") val status: String,
    @SerializedName("data") val data: DataOriginal
)
