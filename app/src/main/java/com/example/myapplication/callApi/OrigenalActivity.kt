package com.example.myapplication.callApi

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapplication.R
import com.example.myapplication.callApi.model.C22List.C22ListQuran
import com.example.myapplication.callApi.model.original.Original
import com.example.myapplication.callApi.service.APIService
import com.example.myapplication.callApi.service.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class OrigenalActivity : AppCompatActivity() {
    private lateinit var tvQuranResponse: TextView
    private lateinit var back: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_origenal)

        tvQuranResponse = findViewById(R.id.tvQuranResponse)
        back = findViewById(R.id.back)

        back.setOnClickListener {
            finish()
        }
//        callApi()
    }

//    fun callApi() {
//        val apiService = ApiClient.retrofit.create(APIService::class.java)
//        val call = apiService.getOriginal()
//
//        call.enqueue(object : Callback<Original> {
//            override fun onResponse(
//                call: Call<Original>, response: Response<Original>
//            ) {
//                if (response.isSuccessful) {
//                    response.body()?.let { original ->
//                        val output = StringBuilder()
//                        output.append("Code: ${original.code}\n")
//                        output.append("Status: ${original.status}\n")
//                        output.append("Data: \n")
//
//                        val edition = original.data.edition
//                        output.append("\nEdition:\n")
//                        output.append("Identifier: ${edition.identifier}\n")
//                        output.append("Language: ${edition.language}\n")
//                        output.append("Name: ${edition.name}\n")
//                        output.append("English Name: ${edition.englishName}\n")
//                        output.append("Format: ${edition.format}\n")
//                        output.append("Type: ${edition.type}\n")
//                        output.append("\nSurahs:\n")
//
//                        val dataOriginal = original.data
//                        dataOriginal.surahs.forEach { surah ->
//                            output.append("Number: ${surah.number}\n ")
//                            output.append("Name: ${surah.name}\n")
//                            output.append("English Name: ${surah.englishName}\n")
//                            output.append("English Name Translation: ${surah.englishNameTranslation}\n")
//                            output.append("Revelation Type: ${surah.revelationType}\n")
//                            surah.ayahs.forEach { ayah ->
//                                output.append("Number: ${ayah.number}\n")
//                                output.append("text: ${ayah.text}\n")
//                                output.append("numberInSurah: ${ayah.numberInSurah}\n")
//                                output.append("juz: ${ayah.juz}\n")
//                                output.append("manzil: ${ayah.manzil}\n")
//                                output.append("page: ${ayah.page}\n")
//                                output.append("ruku: ${ayah.ruku}\n")
//                                output.append("hizbQuarter: ${ayah.hizbQuarter}\n")
//                                output.append("sajda: ${ayah.sajda}\n")
//                            }
//                        }
//
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
//            override fun onFailure(call: Call<Original>, t: Throwable) {
//                Log.e("QuranResponse", "Failed to get response", t)
//                tvQuranResponse.text = "Failed to get response: ${t.message}"
//            }
//        })
//    }
}