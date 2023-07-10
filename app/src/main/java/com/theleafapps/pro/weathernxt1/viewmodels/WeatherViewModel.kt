package com.theleafapps.pro.weathernxt1.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.gson.Gson
import com.theleafapps.pro.weathernxt1.models.WeatherInfo
import com.theleafapps.pro.weathernxt1.repository.WeatherRepository
import com.theleafapps.pro.weathernxt1.utils.APIError
import com.theleafapps.pro.weathernxt1.utils.Constants.api_key
import com.theleafapps.pro.weathernxt1.utils.Constants.units
import com.theleafapps.pro.weathernxt1.utils.TransformUtil
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val repository: WeatherRepository
) : ViewModel() {

    private val dynamicArgumentLiveData = MutableLiveData<String>()
    private var errorMsg:String = ""

    fun setDynamicArgument(dynamicArgument: String) {
        dynamicArgumentLiveData.value = dynamicArgument
    }

    fun getErrorMsg(): String {
        return errorMsg
    }

    // get weather of the city from API and save to db
    fun getWeather() = viewModelScope.launch {
        dynamicArgumentLiveData.value?.let {
            val response = repository.getWeather(it, api_key, units)

            if (response.isSuccessful) {
                response.body()?.let { weatherResponse ->
                    // TransformUtil saves the API Response to simplified form
                    val weatherInfo =
                        TransformUtil.extractWeatherInfoFromResponse(weatherResponse)
                    weatherInfo?.let {
                        repository.insertWeatherInfo(weatherInfo)
                    }
                }
                errorMsg = ""
            } else {
                val msg: APIError = Gson().fromJson(
                    response.errorBody()?.charStream(),
                    APIError::class.java
                )
                Log.d("tag", "getWeather Error: ${msg.message}")
                errorMsg = msg.message.toString()
            }
        }
    }

    // get weather of the city last saved from the room database
    fun getWeatherDB(wId: Int): LiveData<WeatherInfo> {
        return repository.getWeatherInfoFromDB(wId)
    }
}