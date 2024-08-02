package com.example.myapplication.callApi.model.C22List

import com.google.gson.annotations.SerializedName

data class C22ListRuku(
    @SerializedName("surah") val surah: Int,
    @SerializedName("ayah") val ayah: Int,
    )
