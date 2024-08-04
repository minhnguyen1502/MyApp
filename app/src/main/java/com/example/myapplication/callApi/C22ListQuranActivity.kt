package com.example.myapplication.callApi

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R
import com.example.myapplication.callApi.model.C22.C22Quran
import com.example.myapplication.callApi.model.C22List.C22ListQuran
import com.example.myapplication.callApi.service.APIService
import com.example.myapplication.callApi.service.ApiClient
import io.reactivex.rxjava3.schedulers.Schedulers
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class C22ListQuranActivity : AppCompatActivity() {
    private lateinit var tvQuranResponse: TextView
    private lateinit var back: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_c22_list_quaran)

        tvQuranResponse = findViewById(R.id.tvQuranResponse)
        back = findViewById(R.id.back)

        back.setOnClickListener {
            finish()
        }
//        callApi()
    }

//    fun callApi() {
//        val apiService = ApiClient.retrofit.create(APIService::class.java)
//        val call = apiService.getC22List()
//        call.enqueue(object : Callback<C22ListQuran> {
//            override fun onResponse(
//                call: Call<C22ListQuran>, response: Response<C22ListQuran>
//            ) {
//                if (response.isSuccessful) {
//                    response.body()?.let { c22ListQuran ->
//                        val output = StringBuilder()
//                        output.append("Code: ${c22ListQuran.code}\n")
//                        output.append("Status: ${c22ListQuran.status}\n")
//                        output.append("Data: \n")
//                        val c22Data = c22ListQuran.data
//                        output.append("Ayahs Count: ${c22Data.ayahs.count}\n")
//                        output.append("Surahs Count: ${c22Data.surahs.count}\n")
//                        output.append("Surahs References: \n")
//                        c22Data.surahs.references.forEach { surah ->
//                            output.append("Number: ${surah.number}\n ")
//                            output.append("Name: ${surah.name}\n")
//                            output.append("English Name: ${surah.englishName}\n")
//                            output.append("English Name Translation: ${surah.englishNameTranslation}\n")
//                            output.append("Ayahs: ${surah.numberOfAyahs}\n")
//                            output.append("Revelation Type: ${surah.revelationType}\n")
//                        }
//                        output.append("Sajdas Count: ${c22Data.sajdas.count}\n")
//                        output.append("Sajdas References: \n")
//                        c22Data.sajdas.references.forEach { sajda ->
//                           output.append("Surah: ${sajda.surah}\n")
//                           output.append("Ayah: ${sajda.ayah}\n")
//                           output.append("Recommended: ${sajda.recommended}\n")
//                           output.append("Obligatory: ${sajda.obligatory}\n")
//                        }
//                        output.append("Ruku Count: ${c22Data.rukus.count}\n")
//                        output.append("Ruku References: \n")
//                        c22Data.rukus.references.forEach { ruku ->
//                           output.append("Surah: ${ruku.surah}\n")
//                           output.append("Ayah: ${ruku.ayah}\n")
//
//                        }
//                        output.append("pages Count: ${c22Data.pages.count}\n")
//                        output.append("pages References: \n")
//                        c22Data.pages.references.forEach { pages ->
//                           output.append("Surah: ${pages.surah}\n")
//                           output.append("Ayah: ${pages.ayah}\n")
//
//                        }
//                        output.append("manzils Count: ${c22Data.manzils.count}\n")
//                        output.append("manzils References: \n")
//                        c22Data.manzils.references.forEach { manzils ->
//                           output.append("Surah: ${manzils.surah}\n")
//                           output.append("Ayah: ${manzils.ayah}\n")
//
//                        }
//                        output.append("juzs Count: ${c22Data.juzs.count}\n")
//                        output.append("juzs References: \n")
//                        c22Data.juzs.references.forEach { juzs ->
//                           output.append("Surah: ${juzs.surah}\n")
//                           output.append("Ayah: ${juzs.ayah}\n")
//
//                        }
//                        output.append("Hizb Quarters Count: ${c22Data.hizbQuarters.count}\n")
//                        output.append("Hizb Quarters References: \n")
//                        c22Data.hizbQuarters.references.forEach { hizbQuarters ->
//                           output.append("Surah: ${hizbQuarters.surah}\n")
//                           output.append("Ayah: ${hizbQuarters.ayah}\n")
//
//                        }
//                        tvQuranResponse.text = output.toString()
//                    } ?: run {
//                        Log.e("QuranResponse", "Response body is null")
//                        tvQuranResponse.text = "Response body is null"
//                    }
//                } else {
//                    Log.e(
//                        "QuranResponse",
//                        "Response was not successful: ${response.message()}, Code: ${response.code()}"
//                    )
//                    Log.e("QuranResponse", "Response Error Body: ${response.errorBody()?.string()}")
//                    tvQuranResponse.text =
//                        "Response was not successful: ${response.message()}, Code: ${response.code()}"
//                }
//            }
//
//            override fun onFailure(call: Call<C22ListQuran>, t: Throwable) {
//                Log.e("QuranResponse", "Failed to get response", t)
//                tvQuranResponse.text = "Failed to get response: ${t.message}"
//            }
//        })
//    }
}