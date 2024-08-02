package com.example.myapplication.callApi.model.C22List

import com.google.gson.JsonElement
import com.google.gson.annotations.SerializedName

data class C22ListSajdas(
    @SerializedName("surah") val surah: Int,
    @SerializedName("ayah") val ayah: Int,
    @SerializedName("recommended") val recommended: JsonElement,
    @SerializedName("obligatory") val obligatory: JsonElement
    )
