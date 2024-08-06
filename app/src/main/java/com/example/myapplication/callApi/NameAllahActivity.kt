package com.example.myapplication.callApi

import android.app.ProgressDialog
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R
import com.example.myapplication.callApi.model.allahName.NameAllah
import com.example.myapplication.callApi.service.ApiClient
import com.google.gson.Gson
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers

class NameAllahActivity : AppCompatActivity() {
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
        back.setOnClickListener{
            finish()
        }
//        callApi()

    }

//    private fun callApi() {
//        val disposable = ApiClient.apiService.getNameAllah().subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread()).subscribe({ response: NameAllah ->
//                val jsonResponse = Gson().toJson(response)
//                Log.e("API", "99 Name Allah: $jsonResponse")
//                progressDialog.dismiss()
//                tvQuranResponse.text = "done"
//
//            }, { throwable: Throwable ->
//                progressDialog.dismiss()
//                tvQuranResponse.text = "error"
//
//                Toast.makeText(
//                    this,
//                    "Failed to fetch data: ${throwable.message}",
//                    Toast.LENGTH_SHORT
//                ).show()
//            })
//        compositeDisposable.add(disposable)
//    }

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.clear()
        if (::progressDialog.isInitialized && progressDialog.isShowing) {
            progressDialog.dismiss()
        }
    }
//    fun callApi(){
//        val apiService = ApiClient.retrofit.create(APIService::class.java)
//        val call = apiService.getNameAllah()
//
//        call.enqueue(object : Callback<NameAllah> {
//            override fun onResponse(
//                call: Call<NameAllah>,
//                response: Response<NameAllah>
//            ) {
//                if (response.isSuccessful) {
//                    response.body()?.let { nameAllah ->
//                        val output = StringBuilder()
//                        output.append("Code: ${nameAllah.code}\n")
//                        output.append("Status: ${nameAllah.status}\n")
//                        output.append("Data: \n")
//
//                        nameAllah.data.forEach { dataNameAllah ->
//                            output.append("Name: ${dataNameAllah.name}\n")
//                            output.append("Transliteration: ${dataNameAllah.transliteration}\n")
//                            output.append("Number: ${dataNameAllah.number}\n")
//                            output.append("EN: ${dataNameAllah.en.meaning}\n")
//                        }
//
//                        tvQuranResponse.text = output.toString()
//                    } ?: run {
//                        Log.e("C26Translate", "Response body is null")
//                        tvQuranResponse.text = "Response body is null"
//                    }
//                } else {
//                    Log.e("C26Translate", "Response was not successful: ${response.message()}, Code: ${response.code()}")
//                    Log.e("C26Translate", "Response Error Body: ${response.errorBody()?.string()}")
//                    tvQuranResponse.text = "Response was not successful: ${response.message()}, Code: ${response.code()}"
//                }
//            }
//
//            override fun onFailure(call: Call<NameAllah>, t: Throwable) {
//                Log.e("C26Translate", "Failed to get response", t)
//                tvQuranResponse.text = "Failed to get response: ${t.message}"
//            }
//        })
//    }
}
