package com.example.myapplication.callApi.model.C22

import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class C22Quran(
    @SerializedName("code")
    val code: Int,
    @SerializedName("status")
    val status: String,
    @SerializedName("data")
    val data: C22DataQuran

)
