package com.example.myapplication.callApi

import android.app.ProgressDialog
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R
import com.example.myapplication.callApi.model.C24.C24Search
import com.example.myapplication.callApi.service.ApiClient
import com.google.gson.Gson
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers

class C24SearchActivity : AppCompatActivity() {
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
        val disposable = ApiClient.apiService.getC24().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread()).subscribe({ response: C24Search ->
                val jsonResponse = Gson().toJson(response)
                Log.e("API", "C24 Search: $jsonResponse")
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
//        val call = apiService.getC24()
//
//        call.enqueue(object : Callback<C24Search> {
//            override fun onResponse(
//                call: Call<C24Search>, response: Response<C24Search>
//            ) {
//                if (response.isSuccessful) {
//                    response.body()?.let { c24Search ->
//                        val output = StringBuilder()
//                        output.append("Code: ${c24Search.code}\n")
//                        output.append("Status: ${c24Search.status}\n")
//                        output.append("Data: \n")
//
//                        val c24Data = c24Search.data
//                        output.append("Count: ${c24Data.count}\n")
//                        c24Data.matches.forEach { match ->
//                            output.append("Number: ${match.number}\n")
//                            output.append("Text: ${match.text}\n")
//
//                            val edition = match.edition
//                            output.append("Identifier: ${edition.identifier}\n")
//                            output.append("Language: ${edition.language}\n")
//                            output.append("Name: ${edition.name}\n")
//                            output.append("English Name: ${edition.englishName}\n")
//                            output.append("Type: ${edition.type}\n")
//
//                            val surah = match.surah
//                            output.append("Number: ${surah.number}\n")
//                            output.append("Name: ${surah.name}\n")
//                            output.append("English Name: ${surah.englishName}\n")
//                            output.append("English Name Translation: ${surah.englishNameTranslation}\n")
//                            output.append("Revelation Type: ${surah.revelationType}\n")
//
//                            output.append("Number In Surah: ${match.numberInSurah}\n")
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
//            override fun onFailure(call: Call<C24Search>, t: Throwable) {
//                Log.e("QuranResponse", "Failed to get response", t)
//                tvQuranResponse.text = "Failed to get response: ${t.message}"
//            }
//        })
//    }

}