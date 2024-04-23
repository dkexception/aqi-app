package com.dkexception.aqiapp.feature.aqidetails.details

import com.dkexception.aqiapp.feature.aqisdk.model.AirQualityData

data class AQIDetailsScreenState(

    val isLoading: Boolean = false,

    val aqiData: AirQualityData = AirQualityData()
)
