package com.dkexception.aqiapp.feature.aqisdk.repository

import com.dkexception.aqiapp.feature.aqisdk.mapper.toAirQualityData
import com.dkexception.aqiapp.feature.aqisdk.model.AirQualityData
import com.dkexception.aqiapp.feature.aqisdk.network.AirVisualAPIClient
import com.dkexception.core.di.StandardDispatchers
import com.dkexception.core.model.AirVisualAPIError
import com.dkexception.core.model.TaskResult
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
internal class AirVisualDataRepository @Inject constructor(
    private val apiClient: AirVisualAPIClient,
    private val standardDispatchers: StandardDispatchers
) {

    suspend fun getAllCountries(): List<String> = withContext(standardDispatchers.io) {
        when (val countriesResult = apiClient.getAllCountries()) {
            is TaskResult.Error -> emptyList()
            is TaskResult.Success -> countriesResult.data.map { it.country }
        }
    }

    suspend fun getAQIDataByIPLocation(): TaskResult<AirQualityData, AirVisualAPIError> =
        withContext(standardDispatchers.io) {
            when (val result = apiClient.getAirQualityByIPLocation()) {
                is TaskResult.Error -> TaskResult.Error(error = result.error)
                is TaskResult.Success -> TaskResult.Success(
                    data = result.data.toAirQualityData(isFromIPLocation = true)
                )
            }
        }
}
