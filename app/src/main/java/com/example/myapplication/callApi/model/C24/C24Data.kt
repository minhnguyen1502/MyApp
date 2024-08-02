package com.example.myapplication.callApi.model.C24

import com.example.myapplication.callApi.model.C22.C22DataQuran
import com.google.gson.annotations.SerializedName

data class C24Data(
    @SerializedName("count")
    val count: Int,
    @SerializedName("matches")
    val matches: List<C24Matches>
)
