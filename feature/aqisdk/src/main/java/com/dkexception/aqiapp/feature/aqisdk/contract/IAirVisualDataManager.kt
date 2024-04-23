package com.dkexception.aqiapp.feature.aqisdk.contract

import com.dkexception.aqiapp.feature.aqisdk.model.AirQualityData
import com.dkexception.core.model.AirVisualAPIError
import com.dkexception.core.model.TaskResult
import kotlinx.coroutines.flow.StateFlow

interface IAirVisualDataManager {

    val ipLocationData: StateFlow<Pair<Boolean, AirQualityData>>

    val currentLocationData: StateFlow<Pair<Boolean, AirQualityData>>

    suspend fun initialise()

    fun getDataByIPLocation()

    fun getDataByCurrentGeoLocation()

    suspend fun getDataByIPAddress(
        ipAddress: String
    ): TaskResult<AirQualityData, AirVisualAPIError>

    suspend fun getDataByLocation(
        lat: Double,
        lng: Double
    ): TaskResult<AirQualityData, AirVisualAPIError>
}
