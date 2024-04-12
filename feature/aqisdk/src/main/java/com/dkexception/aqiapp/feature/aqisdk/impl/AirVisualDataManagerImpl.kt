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

    private val _state: MutableStateFlow<Boolean> = MutableStateFlow(false)
    override val state: StateFlow<Boolean> get() = _state

    override fun initialise() {

        _state.update { true }

        scope.launch {

            countries = repository.getAllCountries()

            _state.update { false }
        }
    }

    override suspend fun getDataByIPLocation(): TaskResult<AirQualityData, AirVisualAPIError> =
        repository.getAQIDataByIPLocation()

    override suspend fun getDataByLocation(
        lat: Double,
        lng: Double
    ): TaskResult<AirQualityData, AirVisualAPIError> {
        TODO("Not yet implemented")
    }
}
