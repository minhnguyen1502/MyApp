package com.example.myapplication.callApi.service

import com.example.myapplication.callApi.model.C22.C22Quran
import com.example.myapplication.callApi.model.C22List.C22ListQuran
import com.example.myapplication.callApi.model.C24.C24Search
import com.example.myapplication.callApi.model.C26.C26Translate
import com.example.myapplication.callApi.model.C26List.C26ListTranslate
import io.reactivex.rxjava3.core.Single

class ApiRepository(private val apiService: APIService) {

//    fun fetchAllData(): Single<Tuple5<C22Quran, C22ListQuran, C26ListTranslate, C26Translate, C24Search>> {
//        return Single.zip(
//            apiService.getC22(),
//            apiService.getC22List(),
//            apiService.getC26List(),
//            apiService.getC26(),
//            apiService.getC24(),
//            { c22Quran, c22ListQuran, c26ListTranslate, c26Translate, c24Search ->
//                Tuple5(c22Quran, c22ListQuran, c26ListTranslate, c26Translate, c24Search)
//            }
//        )
//    }
}
