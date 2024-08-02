package com.example.myapplication.callApi.model.C22

import com.google.gson.JsonElement
import com.google.gson.annotations.SerializedName

data class C22Ayah (
    @SerializedName("number")
    val number: Int,
    @SerializedName("audio")
    val audio: String,
    @SerializedName("audioSecondary")
    val audioSecondary: List<String>,
    @SerializedName("text")
    val text: String,
    @SerializedName("numberInSurah")
    val numberInSurah: Int,
    @SerializedName("juz")
    val juz: Int,
    @SerializedName("manzil")
    val manzil: Int,
    @SerializedName("page")
    val page: Int,
    @SerializedName("ruku")
    val ruku: Int,
    @SerializedName("hizbQuarter")
    val hizbQuarter: Int,
    @SerializedName("sajda")
    val sajda: JsonElement

)

