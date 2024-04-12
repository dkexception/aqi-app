package com.dkexception.aqiapp.feature.aqisdk.contract

import com.dkexception.aqiapp.feature.aqisdk.model.AirQualityData
import com.dkexception.core.model.AirVisualAPIError
import com.dkexception.core.model.TaskResult
import kotlinx.coroutines.flow.StateFlow

interface IAirVisualDataManager {

    val state: StateFlow<Boolean>

    fun initialise()

    suspend fun getDataByIPLocation(): TaskResult<AirQualityData, AirVisualAPIError>

    suspend fun getDataByLocation(
        lat: Double,
        lng: Double
    ): TaskResult<AirQualityData, AirVisualAPIError>
}
