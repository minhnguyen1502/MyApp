package com.example.myapplication.callApi.model.C22

import com.google.gson.annotations.SerializedName

data class C22Quran(
    @SerializedName("code")
    val code: Int,
    @SerializedName("status")
    val status: String,
    @SerializedName("data")
    val data: C22DataQuran

) {
    override fun toString(): String {
        return "C22Quran(code=$code, status='$status', data=$data)"
    }
}
