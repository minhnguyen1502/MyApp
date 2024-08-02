package com.example.myapplication.callApi.model.C22

import com.google.gson.annotations.SerializedName

data class C22DataQuran(
    @SerializedName("surahs")
    val surahs: List<C22Surah>,
    @SerializedName("edition")
    val edition: C22Edition
)
