package com.example.myapplication.callApi.model.C22JuzList

import com.example.myapplication.callApi.model.C22List.C22ListDataQuran
import com.google.gson.annotations.SerializedName

data class DataC22Juz(
    @SerializedName("number") val number: Int,
    @SerializedName("ayahs") val ayahs: List<Ayah>,
    @SerializedName("surahs") val surahs: Map<String, Surah>,
    @SerializedName("edition") val edition: Edition
)
