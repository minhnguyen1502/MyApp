package com.example.myapplication.callApi

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R
import com.example.myapplication.callApi.model.C22.C22Quran
import com.example.myapplication.callApi.model.C26List.C26ListTranslate
import com.example.myapplication.callApi.service.APIService
import com.example.myapplication.callApi.service.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class C26ListTranslateActivity : AppCompatActivity() {
    private lateinit var tvQuranResponse: TextView
    private lateinit var back: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_c26_list_translate)
        tvQuranResponse = findViewById(R.id.tvQuranResponse)
        back = findViewById(R.id.back)

        back.setOnClickListener{
            finish()
        }
//        callApi()
    }

//    fun callApi(){
//        val apiService = ApiClient.retrofit.create(APIService::class.java)
//        val call = apiService.getC26List()
//
//        call.enqueue(object : Callback<C26ListTranslate> {
//            override fun onResponse(
//                call: Call<C26ListTranslate>,
//                response: Response<C26ListTranslate>
//            ) {
//                if (response.isSuccessful) {
//                    response.body()?.let { c26ListTranslate ->
//                        val output = StringBuilder()
//                        output.append("Code: ${c26ListTranslate.code}\n")
//                        output.append("Status: ${c26ListTranslate.status}\n")
//                        output.append("Data: ${c26ListTranslate.data.joinToString(",")}\n")
//
//                        tvQuranResponse.text = output.toString()
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
//            override fun onFailure(call: Call<C26ListTranslate>, t: Throwable) {
//                Log.e("QuranResponse", "Failed to get response", t)
//                tvQuranResponse.text = "Failed to get response: ${t.message}"
//            }
//        })
//    }
}