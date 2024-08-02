package com.example.myapplication.callApi.model.translation

import com.google.gson.annotations.SerializedName

data class Edition (
    @SerializedName("identifier") val identifier: String,
    @SerializedName("language") val language: String,
    @SerializedName("name") val name: String,
    @SerializedName("englishName") val englishName: String,
    @SerializedName("format") val format: String,
    @SerializedName("type") val type: String
)