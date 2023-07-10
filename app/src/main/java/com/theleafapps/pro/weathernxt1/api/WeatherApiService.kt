package com.theleafapps.pro.weathernxt1.api

import com.theleafapps.pro.weathernxt1.models.WeatherData
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApiService {
    @GET("weather/")
    suspend fun getWeatherData(
        @Query("q") city: String
        ,@Query("APPID") api_key: String
        ,@Query("units") units: String
    ): Response<WeatherData>
}