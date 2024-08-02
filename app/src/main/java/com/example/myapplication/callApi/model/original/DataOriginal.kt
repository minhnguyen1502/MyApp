package com.example.myapplication.callApi.model.original

import com.google.gson.annotations.SerializedName

data class DataOriginal (
    @SerializedName("surahs")
    val surahs: List<Surah>,
    @SerializedName("edition")
    val edition: Edition

)
