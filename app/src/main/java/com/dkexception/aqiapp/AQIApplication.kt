package com.dkexception.aqiapp

import android.app.Application
import com.dkexception.ui.maps.initializer.MapsInitializer
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class AQIApplication : Application() {

    @Inject
    lateinit var mapsInitializer: MapsInitializer

    override fun onCreate() {
        super.onCreate()
        mapsInitializer.initialiseAQIMaps(this.applicationContext)
    }
}
