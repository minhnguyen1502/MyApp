package com.example.myapplication.callApi.model.C24

import com.google.gson.annotations.SerializedName

data class C24Edition(
    @SerializedName("identifier")
    val identifier: String,
    @SerializedName("language")
    val language: String,
    @SerializedName("name")
    val name:String,
    @SerializedName("englishName")
    val englishName: String,
    @SerializedName("type")
    val type: String
)
