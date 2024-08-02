package com.example.myapplication.callApi.model.C22List

import com.google.gson.annotations.SerializedName

data class C22Sajdas(
    @SerializedName("count")
    val count: Int,
    @SerializedName("references")
    val references: List<C22ListSajdas>
)
