package com.example.myapplication.callApi

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.R
import com.example.myapplication.callApi.model.C26.C26Translate
import com.example.myapplication.callApi.model.allahName.NameAllah
import com.example.myapplication.callApi.service.APIService
import com.example.myapplication.callApi.service.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NameAllahActivity : AppCompatActivity() {
    private lateinit var tvQuranResponse: TextView
    private lateinit var back: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_name_allah)
        tvQuranResponse = findViewById(R.id.tvQuranResponse)
        back = findViewById(R.id.back)

        back.setOnClickListener{
            finish()
        }
//        callApi()

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
