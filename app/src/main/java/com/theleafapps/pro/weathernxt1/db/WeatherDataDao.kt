package com.theleafapps.pro.weathernxt1.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Update
import com.theleafapps.pro.weathernxt1.models.WeatherInfo

@Dao
interface WeatherDataDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWeatherInfo(weatherData: WeatherInfo?)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateWeatherInfo(weatherData: WeatherInfo?)

}