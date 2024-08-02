package com.example.myapplication.callApi.model.C26List

import com.example.myapplication.callApi.model.C24.C24Data
import com.google.gson.annotations.SerializedName

data class C26ListTranslate(
    @SerializedName("code") val code: Int,
    @SerializedName("status") val status: String,
    @SerializedName("data") val data: List<String>

) {
    override fun toString(): String {
        return "C26ListTranslate(code=$code, status='$status', data=$data)"
    }
}
