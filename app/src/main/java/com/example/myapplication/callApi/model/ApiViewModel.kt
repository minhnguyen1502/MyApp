package com.example.myapplication.callApi.model

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.callApi.model.C22.C22Quran
import com.example.myapplication.callApi.model.C22List.C22ListQuran
import com.example.myapplication.callApi.model.C24.C24Search
import com.example.myapplication.callApi.model.C26.C26Translate
import com.example.myapplication.callApi.model.C26List.C26ListTranslate
import com.example.myapplication.callApi.model.allahName.NameAllah
import com.example.myapplication.callApi.model.original.Original
import com.example.myapplication.callApi.model.translation.Translation
import com.example.myapplication.callApi.service.APIService
import com.example.myapplication.callApi.service.ApiClient
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers

class ApiViewModel : ViewModel() {
    private val apiService: APIService = ApiClient.retrofit.create(APIService::class.java)
    
    val c22Quran: MutableLiveData<C22Quran> = MutableLiveData()
    val c22ListQuran: MutableLiveData<C22ListQuran> = MutableLiveData()
    val c26ListTranslate: MutableLiveData<C26ListTranslate> = MutableLiveData()
    val c26Translate: MutableLiveData<C26Translate> = MutableLiveData()
    val c24Search: MutableLiveData<C24Search> = MutableLiveData()
    val nameAllah: MutableLiveData<NameAllah> = MutableLiveData()
    val original: MutableLiveData<Original> = MutableLiveData()
    val translation: MutableLiveData<Translation> = MutableLiveData()

    fun fetchAllData() {
        val disposable = CompositeDisposable()
        
        val c22QuranObservable = apiService.getC22().subscribeOn(Schedulers.io())
        val c22ListQuranObservable = apiService.getC22List().subscribeOn(Schedulers.io())
        val c26ListTranslateObservable = apiService.getC26List().subscribeOn(Schedulers.io())
        val c26TranslateObservable = apiService.getC26().subscribeOn(Schedulers.io())
        val c24SearchObservable = apiService.getC24().subscribeOn(Schedulers.io())
        val nameAllahObservable = apiService.getNameAllah().subscribeOn(Schedulers.io())
        val originalObservable = apiService.getOriginal().subscribeOn(Schedulers.io())
        val translationObservable = apiService.getTranslation().subscribeOn(Schedulers.io())
        
        disposable.add(
            Observable.zip(
                c22QuranObservable,
                c22ListQuranObservable,
                c26ListTranslateObservable,
                c26TranslateObservable,
                c24SearchObservable,
                nameAllahObservable,
                originalObservable,
                translationObservable,
                Function8 { c22Quran: C22Quran,
                            c22ListQuran: C22ListQuran,
                            c26ListTranslate: C26ListTranslate,
                            c26Translate: C26Translate,
                            c24Search: C24Search,
                            nameAllah: NameAllah,
                            original: Original,
                            translation: Translation ->
                    c22Quran to c22ListQuran to c26ListTranslate to c26Translate to c24Search to nameAllah to original to translation
                }
            ).observeOn(AndroidSchedulers.mainThread())
            .subscribe({ result ->
                c22Quran.value = result.first
                c22ListQuran.value = result.second.first
                c26ListTranslate.value = result.second.second.first
                c26Translate.value = result.second.second.second.first
                c24Search.value = result.second.second.second.second.first
                nameAllah.value = result.second.second.second.second.second.first
                original.value = result.second.second.second.second.second.second.first
                translation.value = result.second.second.second.second.second.second.second
            }, { error ->
                Log.e("ApiViewModel", "Error fetching data", error)
            })
        )
    }
}
