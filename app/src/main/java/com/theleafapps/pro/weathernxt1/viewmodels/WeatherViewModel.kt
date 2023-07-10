package com.theleafapps.pro.weathernxt1.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.theleafapps.pro.weathernxt1.models.WeatherInfo
import com.theleafapps.pro.weathernxt1.repository.WeatherRepository
import dagger.hilt.android.lifecycle.HiltViewModel
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

    fun getWeatherDB(wId: Int): LiveData<WeatherInfo> {
        return repository.getWeatherInfoFromDB(wId)
    }
}