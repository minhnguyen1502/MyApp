package com.example.myapplication.callApi

import android.annotation.SuppressLint
import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R
import com.example.myapplication.callApi.model.C22.C22Quran
import com.example.myapplication.callApi.model.Octuple
import com.example.myapplication.callApi.service.ApiClient
import com.google.gson.Gson
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers

class MainActivity : AppCompatActivity() {

    private lateinit var tvC22ListQuran: TextView
    private lateinit var tvC22Quran: TextView
    private lateinit var tvC26ListTranslate: TextView
    private lateinit var tvC26Translate: TextView
    private lateinit var tvC24Search: TextView
    private lateinit var tvOriginal: TextView
    private lateinit var tvTranslation: TextView
    private lateinit var tvNameAllah: TextView
    private lateinit var progressDialog: ProgressDialog
    private lateinit var c22QuranData: C22Quran // Variable to hold the C22Quran data

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        progressDialog = ProgressDialog(this).apply {
            setMessage("Loading...")
            setCancelable(false)
        }

        tvC22Quran = findViewById(R.id.c22_quran)
        tvC22ListQuran = findViewById(R.id.c22_list_quran)
        tvC26ListTranslate = findViewById(R.id.c26_list_translate)
        tvC26Translate = findViewById(R.id.c26_translate)
        tvC24Search = findViewById(R.id.c24_search)
        tvOriginal = findViewById(R.id.original)
        tvTranslation = findViewById(R.id.translation)
        tvNameAllah = findViewById(R.id.name_allah)

        //20s
        tvC22Quran.setOnClickListener {
            val intent = Intent(this, C22QuranActivity::class.java)
            startActivity(intent)
        }
        //5s
        tvC22ListQuran.setOnClickListener {
            startActivity(Intent(this, C22ListQuranActivity::class.java))
        }
        //5s
        tvC26ListTranslate.setOnClickListener {
            startActivity(Intent(this, C26ListTranslateActivity::class.java))
        }
        //6s
        tvC24Search.setOnClickListener {
            startActivity(Intent(this, C24SearchActivity::class.java))
        }
        //5s
        tvC26Translate.setOnClickListener {
            startActivity(Intent(this, C26TranslateActivity::class.java))
        }
        //20s
        tvOriginal.setOnClickListener {
            startActivity(Intent(this, OrigenalActivity::class.java))
        }
        //12s
        tvTranslation.setOnClickListener {
            startActivity(Intent(this, TranslationActivity::class.java))
        }
        //3s
        tvNameAllah.setOnClickListener {
            startActivity(Intent(this, NameAllahActivity::class.java))
        }

//        fetchData()
    }

//
//    @SuppressLint("CheckResult")
//    fun fetchData() {
//        val apiService = ApiClient.apiService
//
//        val apiC22Quran = apiService.getC22().subscribeOn(Schedulers.io())
//        val apiC22ListQuran = apiService.getC22List().subscribeOn(Schedulers.io())
//        val apiC26Translate = apiService.getC26().subscribeOn(Schedulers.io())
//        val apiC26ListTranslate = apiService.getC26List().subscribeOn(Schedulers.io())
//        val apiC24Search = apiService.getC24().subscribeOn(Schedulers.io())
//        val apiNameAllah = apiService.getNameAllah().subscribeOn(Schedulers.io())
//        val apiTranslation = apiService.getTranslation().subscribeOn(Schedulers.io())
//        val apiOriginal = apiService.getOriginal().subscribeOn(Schedulers.io())
//
//        progressDialog.show()
//
//        Single.zip(apiC22Quran,
//            apiC22ListQuran,
//            apiC26Translate,
//            apiC26ListTranslate,
//            apiC24Search,
//            apiOriginal,
//            apiTranslation,
//            apiNameAllah
//        ) { C22Quran,
//            C22ListQuran,
//            C26Translate,
//            C26ListTranslate,
//            C24Search,
//            Original,
//            Translation,
//            NameAllah ->
//            Octuple(
//                C22Quran,
//                C22ListQuran,
//                C26Translate,
//                C26ListTranslate,
//                C24Search,
//                Original,
//                Translation,
//                NameAllah
//            )
//        }
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribe({ result ->
//                progressDialog.dismiss()
//                val(C22Quran,
//                    C22ListQuran,
//                    C26Translate,
//                    C26ListTranslate,
//                    C24Search,
//                    Original,
//                    Translation,
//                    NameAllah) = result
//                Log.d("API_RESPONSE", "C22Quran: ${C22Quran.toString()}")
//                Log.d("API_RESPONSE", "C22ListQuran: ${C22ListQuran.toString()}")
//                Log.d("API_RESPONSE", "C26Translate: ${C26Translate.toString()}")
//                Log.d("API_RESPONSE", "C26ListTranslate: ${C26ListTranslate.toString()}")
//                Log.d("API_RESPONSE", "C24Search: ${C24Search.toString()}")
//                Log.d("API_RESPONSE", "Original: ${Original.toString()}")
//                Log.d("API_RESPONSE", "Translation: ${Translation.toString()}")
//                Log.d("API_RESPONSE", "NameAllah: ${NameAllah.toString()}")
//            },{error ->
//                progressDialog.dismiss()
//                error.printStackTrace()
//
//            })
//    }

}