package com.theleafapps.pro.weathernxt1.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.theleafapps.pro.weathernxt1.models.WeatherInfo

@Dao
interface WeatherDataDAO {

    //Insert to db
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWeatherInfo(weatherData: WeatherInfo?)

    //Update to db
    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateWeatherInfo(weatherData: WeatherInfo?)

    //get weather data saved in db
    @Query("SELECT * FROM WeatherInfo where id=:wId")
    fun getLastCityWeatherInfo(wId: Int): LiveData<WeatherInfo>
}