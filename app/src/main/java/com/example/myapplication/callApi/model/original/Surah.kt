package com.example.myapplication.callApi.model.original

import com.google.gson.annotations.SerializedName

data class Surah (
    @SerializedName("number") val number: Int,
    @SerializedName("name") val name: String,
    @SerializedName("englishName") val englishName: String,
    @SerializedName("englishNameTranslation") val englishNameTranslation: String,
    @SerializedName("revelationType") val revelationType: String,
    @SerializedName("ayahs") val ayahs: List<Ayah>

)
