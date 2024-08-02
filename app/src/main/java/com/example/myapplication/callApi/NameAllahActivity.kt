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
import com.example.myapplication.callApi.model.ApiViewModel
import com.example.myapplication.callApi.model.C26.C26Translate
import com.example.myapplication.callApi.model.allahName.NameAllah
import com.example.myapplication.callApi.service.APIService
import com.example.myapplication.callApi.service.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NameAllahActivity : AppCompatActivity() {
    private lateinit var viewModel: ApiViewModel
    private lateinit var tvQuranResponse: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_name_allah)
        tvQuranResponse = findViewById(R.id.tvQuranResponse)

        viewModel = ViewModelProvider(this).get(ApiViewModel::class.java)

        viewModel.nameAllah.observe(this, { nameAllah ->
            val output = StringBuilder()
            output.append("Code: ${nameAllah.code}\n")
            output.append("Status: ${nameAllah.status}\n")
            output.append("Data: \n")

            nameAllah.data.forEach { dataNameAllah ->
                output.append("Name: ${dataNameAllah.name}\n")
                output.append("Transliteration: ${dataNameAllah.transliteration}\n")
                output.append("Number: ${dataNameAllah.number}\n")
                output.append("EN: ${dataNameAllah.en.meaning}\n")
            }

            tvQuranResponse.text = output.toString()
        })
    }
}
