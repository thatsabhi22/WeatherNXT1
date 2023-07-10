package com.theleafapps.pro.weathernxt1.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.theleafapps.pro.weathernxt1.R
import com.theleafapps.pro.weathernxt1.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WeatherActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}