package com.dkexception.aqiapp.carapp.screens.home

import com.dkexception.aqiapp.feature.aqisdk.model.AirQualityData

data class HomeScreenState(

    val isLoading: Boolean = true,

    val isError: Boolean = false,

    val userName: String = "User",

    val aqiData: AirQualityData = AirQualityData()
)
