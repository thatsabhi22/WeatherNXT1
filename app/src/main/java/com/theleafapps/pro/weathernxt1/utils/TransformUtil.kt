package com.theleafapps.pro.weathernxt1.utils

import com.theleafapps.pro.weathernxt1.models.WeatherData
import com.theleafapps.pro.weathernxt1.models.WeatherInfo

object TransformUtil {
    // method transforms the weather data api response to simplified WeatherInfo Object
    public fun extractWeatherInfoFromResponse(weatherData: WeatherData): WeatherInfo? {
        val weatherInfo = WeatherInfo(
            id = 1,
            city_name = weatherData.name.toString(),
            temperature = weatherData.main.temp.toString(),
            pressure = weatherData.main.pressure.toString(),
            windSpeed = weatherData.wind.speed.toString(),
            humidity = weatherData.main.humidity.toString(),
            visibility = weatherData.visibility.toString(),
            sunrise = weatherData.sys.sunrise,
            sunset = weatherData.sys.sunset,
            detail = weatherData.weather[0].main.toString()
        )
        return weatherInfo
    }
}