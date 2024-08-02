package com.example.myapplication.callApi.model.C22List

import com.google.gson.annotations.SerializedName

data class C22ListDataQuran(
    @SerializedName("ayahs") val ayahs: C22Ayah,
    @SerializedName("surahs") val surahs: C22Surah,
    @SerializedName("sajdas") val sajdas: C22Sajdas,
    @SerializedName("rukus") val rukus: C22Ruku,
    @SerializedName("pages") val pages: C22Ruku,
    @SerializedName("manzils") val manzils: C22Ruku,
    @SerializedName("hizbQuarters") val hizbQuarters: C22Ruku,
    @SerializedName("juzs") val juzs: C22Ruku
)

