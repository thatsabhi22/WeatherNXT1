package com.theleafapps.pro.weathernxt1.di

import com.theleafapps.pro.weathernxt1.repository.WeatherRepository
import com.theleafapps.pro.weathernxt1.viewmodels.WeatherViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object WeatherViewModelModule {

    @Provides
    fun provideMyViewModel(
        myRepository: WeatherRepository
    ): WeatherViewModel {
        return WeatherViewModel(myRepository)
    }
}
