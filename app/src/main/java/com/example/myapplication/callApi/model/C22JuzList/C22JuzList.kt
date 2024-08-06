package com.example.myapplication.callApi.model.C22JuzList

import com.example.myapplication.callApi.model.C22List.C22ListDataQuran
import com.google.gson.annotations.SerializedName

data class C22JuzList(
    @SerializedName("code") val code: Int,
    @SerializedName("status") val status: String,
    @SerializedName("data") val data: DataC22Juz
)
