package com.theleafapps.pro.weathernxt1.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.theleafapps.pro.weathernxt1.R
import com.theleafapps.pro.weathernxt1.databinding.ActivityMainBinding
import com.theleafapps.pro.weathernxt1.utils.Constants.wId
import com.theleafapps.pro.weathernxt1.viewmodels.WeatherViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WeatherActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: WeatherViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.getWeatherDB(wId).observe(this) { weatherData ->
            weatherData?.let {
            }
        }
    }
}