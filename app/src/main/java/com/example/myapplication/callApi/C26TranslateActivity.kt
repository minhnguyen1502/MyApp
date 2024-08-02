package com.example.myapplication.callApi

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R
import com.example.myapplication.callApi.model.C26.C26Translate
import com.example.myapplication.callApi.model.C26List.C26ListTranslate
import com.example.myapplication.callApi.service.APIService
import com.example.myapplication.callApi.service.ApiClient

class C26TranslateActivity : AppCompatActivity() {
    private lateinit var tvQuranResponse: TextView
    private lateinit var back: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_c26_translate)
        tvQuranResponse = findViewById(R.id.tvQuranResponse)
        back = findViewById(R.id.back)

        back.setOnClickListener{
            finish()
        }
//        callApi()
    }

//    fun callApi(){
//        val apiService = ApiClient.retrofit.create(APIService::class.java)
//        val call = apiService.getC26()
//
//        call.enqueue(object : Callback<C26Translate> {
//            override fun onResponse(
//                call: Call<C26Translate>,
//                response: Response<C26Translate>
//            ) {
//                if (response.isSuccessful) {
//                    response.body()?.let { c26Translate ->
//                        val output = StringBuilder()
//                        output.append("Code: ${c26Translate.code}\n")
//                        output.append("Status: ${c26Translate.status}\n")
//                        output.append("Data: \n")
//
//                        c26Translate.data.forEach{c26Data ->
//                            output.append("Identifier: ${c26Data.identifier}\n")
//                            output.append("Language: ${c26Data.language}\n")
//                            output.append("Name: ${c26Data.name}\n")
//                            output.append("English Name: ${c26Data.englishName}\n")
//                            output.append("Format: ${c26Data.format}\n")
//                            output.append("Type: ${c26Data.type}\n")
//                            output.append("Direction: ${c26Data.direction}\n\n")
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
//            override fun onFailure(call: Call<C26Translate>, t: Throwable) {
//                Log.e("C26Translate", "Failed to get response", t)
//                tvQuranResponse.text = "Failed to get response: ${t.message}"
//            }
//        })
//    }
}