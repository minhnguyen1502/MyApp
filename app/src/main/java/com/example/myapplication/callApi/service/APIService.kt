package com.example.myapplication.callApi.service

import com.example.myapplication.callApi.model.C22List.C22ListQuran
import com.example.myapplication.callApi.model.C22.C22Quran
import com.example.myapplication.callApi.model.C22JuzList.C22JuzList
import com.example.myapplication.callApi.model.C24.C24Search
import com.example.myapplication.callApi.model.C26.C26Translate
import com.example.myapplication.callApi.model.C26List.C26ListTranslate
import com.example.myapplication.callApi.model.allahName.NameAllah
import com.example.myapplication.callApi.model.original.Original
import com.example.myapplication.callApi.model.translation.Translation
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface APIService {
    // https://api.alquran.cloud/v1/quran/ar.alafasy
    @GET("quran/ar.alafasy")
    fun getC22(): Observable<C22Quran>

    // https://api.alquran.cloud/v1/meta
    @GET("meta")
    fun getC22List(): Observable<C22ListQuran>

    // https://api.alquran.cloud/v1/edition/language
    @GET("edition/language")
    fun getC26List(): Observable<C26ListTranslate>

    // https://api.alquran.cloud/v1/edition/type/translation
    @GET("edition/type/translation")
    fun getC26(): Observable<C26Translate>

    // http://api.alquran.cloud/v1/search/Abraham/all/en
    @GET("search/Abraham/all/en")
    fun getC24(): Observable<C24Search>

    //https://api.aladhan.com/v1/asmaAlHusna/77
    @GET("https://api.aladhan.com/v1/asmaAlHusna")
    fun getNameAllah(): Observable<NameAllah>

    //https://api.alquran.cloud/v1/quran/quran-uthmani
    @GET("quran/quran-uthmani")
    fun getOriginal(): Observable<Original>

    // https://api.alquran.cloud/v1/juz/1/quran-uthmani?offset=9&limit=5
    @GET("juz/1/quran-uthmani")
    fun getC22Juz(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): Observable<C22JuzList>

    //https://api.alquran.cloud/v1/quran/en.asad
    @GET("quran/en.asad")
    fun getTranslation(): Observable<Translation>
//    @GET("quran/ar.alafasy")
//    fun getC22(): Single<C22Quran>
//
//    @GET("meta")
//    fun getC22List(): Single<C22ListQuran>
//
//    @GET("edition/language")
//    fun getC26List(): Single<C26ListTranslate>
//
//    @GET("edition/type/translation")
//    fun getC26(): Single<C26Translate>
//
//    @GET("search/Abraham/all/en")
//    fun getC24(): Single<C24Search>
//
//    @GET("https://api.aladhan.com/v1/asmaAlHusna")
//    fun getNameAllah(): Single<NameAllah>
//
//    @GET("quran/quran-uthmani")
//    fun getOriginal(): Single<Original>
//
//    @GET("quran/en.asad")
//    fun getTranslation(): Single<Translation>
//    @GET("quran/ar.alafasy")
//    fun getC22(): Call<C22Quran>
//
//    @GET("meta")
//    fun getC22List(): Call<C22ListQuran>
//
//    @GET("edition/language")
//    fun getC26List(): Call<C26ListTranslate>
//
//    @GET("edition/type/translation")
//    fun getC26(): Call<C26Translate>
//
//    @GET("search/Abraham/all/en")
//    fun getC24(): Call<C24Search>
//
//    @GET("https://api.aladhan.com/v1/asmaAlHusna")
//    fun getNameAllah(): Call<NameAllah>
//
//    @GET("quran/quran-uthmani")
//    fun getOriginal(): Call<Original>
//
//    @GET("quran/en.asad")
//    fun getTranslation(): Call<Translation>
}

