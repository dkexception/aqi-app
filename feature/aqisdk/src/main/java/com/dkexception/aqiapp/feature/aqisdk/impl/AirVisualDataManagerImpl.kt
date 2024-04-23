package com.dkexception.aqiapp.feature.aqisdk.impl

import com.dkexception.aqiapp.feature.aqisdk.contract.IAirVisualDataManager
import com.dkexception.aqiapp.feature.aqisdk.model.AirQualityData
import com.dkexception.aqiapp.feature.aqisdk.repository.AirVisualDataRepository
import com.dkexception.core.di.StandardDispatchers
import com.dkexception.core.model.AirVisualAPIError
import com.dkexception.core.model.TaskResult
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
internal class AirVisualDataManagerImpl @Inject constructor(
    standardDispatchers: StandardDispatchers,
    private val repository: AirVisualDataRepository
) : IAirVisualDataManager {

    private val scope = CoroutineScope(SupervisorJob() + standardDispatchers.io)

    private var countries: List<String> = listOf()

    private val _ipLocationData: MutableStateFlow<Pair<Boolean, AirQualityData>> =
        MutableStateFlow(false to AirQualityData())
    override val ipLocationData: StateFlow<Pair<Boolean, AirQualityData>> get() = _ipLocationData

    private val _currentLocationData: MutableStateFlow<Pair<Boolean, AirQualityData>> =
        MutableStateFlow(false to AirQualityData())
    override val currentLocationData: StateFlow<Pair<Boolean, AirQualityData>> get() = _currentLocationData

    override suspend fun initialise() {
        countries = repository.getAllCountries()
    }

    override fun getDataByIPLocation() {

        _ipLocationData.update {
            it.copy(first = true)
        }

        scope.launch {
            when (val result = repository.getAQIDataByIPLocation()) {
                is TaskResult.Error -> Unit
                is TaskResult.Success -> {
                    _ipLocationData.update { false to result.data }
                }
            }

            _ipLocationData.update {
                it.copy(first = false)
            }
        }
    }

    override fun getDataByCurrentGeoLocation() {

        _currentLocationData.update {
            it.copy(first = true)
        }

        scope.launch {

            _currentLocationData.update {
                it.copy(first = false)
            }
        }
    }

    override suspend fun getDataByIPAddress(ipAddress: String): TaskResult<AirQualityData, AirVisualAPIError> {
        TODO("Not yet implemented")
    }

    override suspend fun getDataByLocation(
        lat: Double,
        lng: Double
    ): TaskResult<AirQualityData, AirVisualAPIError> {
        TODO("Not yet implemented")
    }
}
