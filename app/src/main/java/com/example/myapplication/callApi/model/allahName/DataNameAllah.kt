package com.example.myapplication.callApi.model.allahName

import com.google.gson.annotations.SerializedName

data class DataNameAllah(
    @SerializedName("name") val name: String,
    @SerializedName("transliteration") val transliteration: String,
    @SerializedName("number") val number: Int,
    @SerializedName("en") val en: En

    )
