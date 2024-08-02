package com.example.myapplication.callApi.service

import com.example.myapplication.callApi.model.C22List.C22ListQuran
import com.example.myapplication.callApi.model.C22.C22Quran
import com.example.myapplication.callApi.model.C24.C24Search
import com.example.myapplication.callApi.model.C26.C26Translate
import com.example.myapplication.callApi.model.C26List.C26ListTranslate
import com.example.myapplication.callApi.model.allahName.NameAllah
import com.example.myapplication.callApi.model.original.Original
import com.example.myapplication.callApi.model.translation.Translation
import io.reactivex.rxjava3.core.Single
import retrofit2.Call
import retrofit2.http.GET

interface APIService {
    @GET("quran/ar.alafasy")
    fun getC22(): Single<C22Quran>

    @GET("meta")
    fun getC22List(): Single<C22ListQuran>

    @GET("edition/language")
    fun getC26List(): Single<C26ListTranslate>

    @GET("edition/type/translation")
    fun getC26(): Single<C26Translate>

    @GET("search/Abraham/all/en")
    fun getC24(): Single<C24Search>

    @GET("https://api.aladhan.com/v1/asmaAlHusna")
    fun getNameAllah(): Single<NameAllah>

    @GET("quran/quran-uthmani")
    fun getOriginal(): Single<Original>

    @GET("quran/en.asad")
    fun getTranslation(): Single<Translation>
}

