package com.example.myapplication.callApi.model.C26

import com.example.myapplication.callApi.model.C24.C24Data
import com.google.gson.annotations.SerializedName

data class C26Translate(
    @SerializedName("code") val code: Int,
    @SerializedName("status") val status: String,
    @SerializedName("data") val data: List<C26Data>

) {
    override fun toString(): String {
        return "C26Translate(code=$code, status='$status', data=$data)"
    }
}
