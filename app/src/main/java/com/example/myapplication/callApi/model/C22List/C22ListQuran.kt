package com.example.myapplication.callApi.model.C22List

import com.google.gson.annotations.SerializedName

data class C22ListQuran(
    @SerializedName("code") val code: Int,
    @SerializedName("status") val status: String,
    @SerializedName("data") val data: C22ListDataQuran

) {
    override fun toString(): String {
        return "C22ListQuran(code=$code, status='$status', data=$data)"
    }
}
