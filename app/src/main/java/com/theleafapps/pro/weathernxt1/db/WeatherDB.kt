package com.theleafapps.pro.weathernxt1.db

import android.content.Context
import android.util.Log
import androidx.room.Room
import androidx.room.RoomDatabase

abstract class WeatherDB : RoomDatabase() {
    abstract fun weatherDataDAO(): WeatherDataDAO

    companion object {
        private val LOG_TAG = WeatherDB::class.java.simpleName
        private val LOCK = Any()
        private const val DATABASE_NAME = "weatherData.db"

        @Volatile
        private var sInstance: WeatherDB? = null
        fun getInstance(context: Context): WeatherDB? {
            if (sInstance == null) {
                synchronized(LOCK) {
                    if (sInstance == null) {
                        Log.d(
                            LOG_TAG,
                            "Creating new database instance"
                        )
                        sInstance =
                            Room.databaseBuilder(
                                context.applicationContext,
                                WeatherDB::class.java,
                                DATABASE_NAME
                            ).build()
                    }
                }
            }
            Log.d(LOG_TAG, "Getting the database instance")
            return sInstance
        }
    }
}