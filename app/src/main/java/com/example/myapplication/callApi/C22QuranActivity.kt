package com.example.myapplication.callApi

import android.app.ProgressDialog
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R
import com.example.myapplication.callApi.model.C22.C22Quran
import com.example.myapplication.callApi.service.ApiClient
import com.google.gson.Gson
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers

class C22QuranActivity : AppCompatActivity() {

    private lateinit var tvQuranResponse: TextView
    private lateinit var back: TextView

    private val compositeDisposable = CompositeDisposable()
    private lateinit var progressDialog: ProgressDialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_call_api)
        tvQuranResponse = findViewById(R.id.tvQuranResponse)
        back = findViewById(R.id.back)

        back.setOnClickListener{
            finish()
        }
        progressDialog = ProgressDialog(this).apply {
            setMessage("Loading...")
            setCancelable(false)
            show()
        }
//        val jsonC22Quran = intent.getStringExtra("C22_QURAN_DATA")
//        val gson = Gson()
//        val c22QuranData = gson.fromJson(jsonC22Quran, C22Quran::class.java)
//
//        // Display the data
//        displayC22QuranData(c22QuranData)
        callApi()
    }

    private fun callApi() {
        val disposable = ApiClient.apiService.getC22().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread()).subscribe({ response: C22Quran ->
                val jsonResponse = Gson().toJson(response)
                Log.e("API", "C22 Quran: $jsonResponse")
                progressDialog.dismiss()
                tvQuranResponse.text = "done"

            }, { throwable: Throwable ->
                progressDialog.dismiss()
                tvQuranResponse.text = "error"

                Toast.makeText(
                    this,
                    "Failed to fetch data: ${throwable.message}",
                    Toast.LENGTH_SHORT
                ).show()
            })
        compositeDisposable.add(disposable)
    }

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.clear()
        if (::progressDialog.isInitialized && progressDialog.isShowing) {
            progressDialog.dismiss()
        }
    }
//    private fun displayC22QuranData(data: C22Quran) {
//        val builder = StringBuilder()
//        builder.append("Code: ${data.code}\n")
//        builder.append("Status: ${data.status}\n")
//        builder.append("Edition: ${data.data.edition.name}\n")
//        builder.append("Surahs:\n")
//
//        data.data.surahs.forEach { surah ->
//            builder.append("  - ${surah.name} (${surah.englishName})\n")
//        }
//
//        tvQuranResponse.text = builder.toString()
//    }
//    fun callApi(){
//        val apiService = ApiClient.retrofit.create(APIService::class.java)
//        val call = apiService.getC22()
//
//        call.enqueue(object : Callback<C22Quran> {
//            override fun onResponse(
//                call: Call<C22Quran>,
//                response: Response<C22Quran>
//            ) {
//                if (response.isSuccessful) {
//                    response.body()?.let { quranResponse ->
//                        val output = StringBuilder()
//                        output.append("Code: ${quranResponse.code}\n")
//                        output.append("Status: ${quranResponse.status}\n")
//
//                        // Format and append Edition details
//                        val edition = quranResponse.data.edition
//                        output.append("\nEdition:\n")
//                        output.append("Identifier: ${edition.identifier}\n")
//                        output.append("Language: ${edition.language}\n")
//                        output.append("Name: ${edition.name}\n")
//                        output.append("English Name: ${edition.englishName}\n")
//                        output.append("Format: ${edition.format}\n")
//                        output.append("Type: ${edition.type}\n")
//
//                        // Format and append Surah details
//                        quranResponse.data.surahs.forEach { surah ->
//                            output.append("\nSurah ${surah.number}:\n")
//                            output.append("Name: ${surah.name}\n")
//                            output.append("English Name: ${surah.englishName}\n")
//                            output.append("English Name Translation: ${surah.englishNameTranslation}\n")
//                            output.append("Revelation Type: ${surah.revelationType}\n")
//                            // Format and append Ayah details
//                            surah.ayahs.forEach { ayah ->
//                                output.append("\nAyah ${ayah.numberInSurah}:\n")
//                                output.append("Text: ${ayah.text}\n")
//                                output.append("Audio: ${ayah.audio}\n")
//                                output.append("Audio Secondary: ${ayah.audioSecondary.joinToString(", ")}\n")
//                                output.append("Juz: ${ayah.juz}\n")
//                                output.append("Manzil: ${ayah.manzil}\n")
//                                output.append("Page: ${ayah.page}\n")
//                                output.append("Ruku: ${ayah.ruku}\n")
//                                output.append("Hizb Quarter: ${ayah.hizbQuarter}\n")
//                                output.append("Sajda: ${ayah.sajda}\n")
//                            }
//                        }
//
//                         tvQuranResponse.text = output.toString()
//                    } ?: run {
//                        Log.e("QuranResponse", "Response body is null")
//                        tvQuranResponse.text = "Response body is null"
//                    }
//                } else {
//                    Log.e("QuranResponse", "Response was not successful: ${response.message()}, Code: ${response.code()}")
//                    Log.e("QuranResponse", "Response Error Body: ${response.errorBody()?.string()}")
//                    tvQuranResponse.text = "Response was not successful: ${response.message()}, Code: ${response.code()}"
//                }
//            }
//
//            override fun onFailure(call: Call<C22Quran>, t: Throwable) {
//                Log.e("QuranResponse", "Failed to get response", t)
//                tvQuranResponse.text = "Failed to get response: ${t.message}"
//            }
//        })
//    }

}
