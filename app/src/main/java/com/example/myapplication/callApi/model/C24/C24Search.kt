package com.example.myapplication.callApi.model.C24

import com.example.myapplication.callApi.model.C22.C22DataQuran
import com.google.gson.annotations.SerializedName

data class C24Search(
    @SerializedName("code") val code: Int,
    @SerializedName("status") val status: String,
    @SerializedName("data") val data: C24Data


) {
    override fun toString(): String {
        return "C24Search(code=$code, status='$status', data=$data)"
    }
}
