package com.example.myapplication.callApi.model.C24

import com.google.gson.annotations.SerializedName

data class C24Matches(
    @SerializedName("number") val number: Int,
    @SerializedName("text") val text: String,
    @SerializedName("edition") val edition: C24Edition,
    @SerializedName("surah") val surah: C24Surah,
    @SerializedName("numberInSurah") val numberInSurah: Int
)