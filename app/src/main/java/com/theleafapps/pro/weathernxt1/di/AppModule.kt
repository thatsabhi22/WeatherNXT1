package com.theleafapps.pro.weathernxt1.di

import com.theleafapps.pro.weathernxt1.api.WeatherApiService
import com.theleafapps.pro.weathernxt1.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    fun provideBaseUrl() = Constants.BASE_URL

    @Provides
    @Singleton
    fun provideRetrofitInstance(BASE_URL: String): WeatherApiService =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(WeatherApiService::class.java)

    @Provides
    @Singleton
    fun provideWeatherDataDao(weatherDb: WeatherDB): WeatherDataDAO {
        return weatherDb.weatherDataDAO()
    }
}