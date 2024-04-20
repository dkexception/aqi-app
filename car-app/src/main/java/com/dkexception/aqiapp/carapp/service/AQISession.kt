package com.dkexception.aqiapp.carapp.service

import android.content.Intent
import androidx.car.app.Screen
import androidx.car.app.Session
import com.dkexception.aqiapp.carapp.screens.home.HomeScreen
import com.dkexception.aqiapp.feature.aqisdk.contract.IAirVisualDataManager
import javax.inject.Inject

class AQISession @Inject constructor(
    private val aqiDataManager: IAirVisualDataManager
) : Session() {

    override fun onCreateScreen(intent: Intent): Screen = HomeScreen(
        carContext = carContext,
        aqiDataManager = aqiDataManager
    )
}
