package com.example.myapplication.callApi.model.C24

import com.google.gson.annotations.SerializedName

data class C24Surah(
    @SerializedName("number") val number: Int,
    @SerializedName("name") val name: String,
    @SerializedName("englishName") val englishName: String,
    @SerializedName("englishNameTranslation") val englishNameTranslation: String,
    @SerializedName("revelationType") val revelationType: String
)
