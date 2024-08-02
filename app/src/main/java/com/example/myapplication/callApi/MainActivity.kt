package com.example.myapplication.callApi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.callApi.model.ApiViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var tvC22ListQuran: TextView
    private lateinit var tvC22Quran: TextView
    private lateinit var tvC26ListTranslate: TextView
    private lateinit var tvC26Translate: TextView
    private lateinit var tvC24Search: TextView
    private lateinit var tvOriginal: TextView
    private lateinit var tvTranslation: TextView
    private lateinit var tvNameAllah: TextView
    private lateinit var viewModel: ApiViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvC22Quran = findViewById(R.id.c22_quran)
        tvC22ListQuran = findViewById(R.id.c22_list_quran)
        tvC26ListTranslate = findViewById(R.id.c26_list_translate)
        tvC26Translate = findViewById(R.id.c26_translate)
        tvC24Search = findViewById(R.id.c24_search)
        tvOriginal = findViewById(R.id.original)
        tvTranslation = findViewById(R.id.translation)
        tvNameAllah = findViewById(R.id.name_allah)

        viewModel = ViewModelProvider(this).get(ApiViewModel::class.java)
        viewModel.fetchAllData()

        tvC22Quran.setOnClickListener {
            val intent = Intent(this, C22QuranActivity::class.java)
            startActivity(intent)
        }
        tvC22ListQuran.setOnClickListener {
            startActivity(Intent(this, C22ListQuranActivity::class.java))
        }
        tvC24Search.setOnClickListener {
            startActivity(Intent(this, C24SearchActivity::class.java))
        }
        tvC26Translate.setOnClickListener {
            startActivity(Intent(this, C26TranslateActivity::class.java))
        }
        tvOriginal.setOnClickListener {
            startActivity(Intent(this, OrigenalActivity::class.java))
        }
        tvTranslation.setOnClickListener {
            startActivity(Intent(this, TranslationActivity::class.java))
        }
        tvNameAllah.setOnClickListener {
            startActivity(Intent(this, NameAllahActivity::class.java))
        }


    }


}