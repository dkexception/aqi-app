package com.dkexception.aqiapp.feature.home.home

import com.dkexception.aqiapp.feature.aqisdk.model.AirQualityData

data class HomeScreenState(

    val isLoading: Boolean = false,

    val userName: String = "User",

    val aqiData: AirQualityData? = null
)
