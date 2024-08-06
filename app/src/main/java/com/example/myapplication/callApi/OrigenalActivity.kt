package com.example.myapplication.callApi

import android.app.ProgressDialog
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R
import com.example.myapplication.callApi.model.original.Original
import com.example.myapplication.callApi.service.ApiClient
import com.google.gson.Gson
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers

class OrigenalActivity : AppCompatActivity() {
    private lateinit var tvQuranResponse: TextView
    private lateinit var back: TextView
    private val compositeDisposable = CompositeDisposable()
    private lateinit var progressDialog: ProgressDialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_call_api)

        tvQuranResponse = findViewById(R.id.tvQuranResponse)
        back = findViewById(R.id.back)
        progressDialog = ProgressDialog(this).apply {
            setMessage("Loading...")
            setCancelable(false)
            show()
        }
        back.setOnClickListener {
            finish()
        }
        callApi()
    }
    private fun callApi() {
        val disposable = ApiClient.apiService.getOriginal().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread()).subscribe({ response: Original ->
                val jsonResponse = Gson().toJson(response)
                Log.e("API", "Original: $jsonResponse")
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