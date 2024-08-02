package com.example.myapplication.callApi.model.translation

import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("surahs") val surahs: List<Surah>,
    @SerializedName("edition") val edition: Edition

    )
