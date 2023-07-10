package com.theleafapps.pro.weathernxt1.repository

import androidx.lifecycle.LiveData
import com.theleafapps.pro.weathernxt1.api.WeatherApiService
import com.theleafapps.pro.weathernxt1.db.WeatherDataDAO
import com.theleafapps.pro.weathernxt1.models.WeatherInfo
import javax.inject.Inject

class WeatherRepository @Inject
constructor(private val weatherApiService: WeatherApiService,
            private val weatherDataDao: WeatherDataDAO) {

    suspend fun getWeather(cityName: String, apiKey: String, units: String) =
        weatherApiService.getWeatherData(cityName,apiKey,units)

    suspend fun insertWeatherInfo(weatherInfo: WeatherInfo) =
        weatherDataDao.insertWeatherInfo(weatherInfo)

    fun getWeatherInfoFromDB(wId:Int): LiveData<WeatherInfo> =
        weatherDataDao.getLastCityWeatherInfo(wId)
}