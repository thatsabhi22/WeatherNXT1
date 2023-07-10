package com.theleafapps.pro.weathernxt1.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.theleafapps.pro.weathernxt1.models.WeatherInfo

@Dao
interface WeatherDataDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWeatherInfo(weatherData: WeatherInfo?)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateWeatherInfo(weatherData: WeatherInfo?)

    @Query("SELECT * FROM WeatherInfo where id=:wId")
    fun getLastCityWeatherInfo(wId: Int): LiveData<WeatherInfo>
}