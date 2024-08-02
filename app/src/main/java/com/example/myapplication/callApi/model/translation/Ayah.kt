package com.example.myapplication.callApi.model.translation

import com.google.gson.JsonElement
import com.google.gson.annotations.SerializedName

data class Ayah(
    @SerializedName("number") val number: Int,
    @SerializedName("text") val text: String,
    @SerializedName("numberInSurah") val numberInSurah: Int,
    @SerializedName("juz") val juz: Int,
    @SerializedName("manzil") val manzil: Int,
    @SerializedName("page") val page: Int,
    @SerializedName("ruku") val ruku: Int,
    @SerializedName("hizbQuarter") val hizbQuarter: Int,
    @SerializedName("sajda") val sajda: JsonElement

    )
