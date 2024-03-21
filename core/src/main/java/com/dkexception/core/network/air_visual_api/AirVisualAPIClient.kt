package com.dkexception.core.network.air_visual_api

import com.dkexception.aqiapp.core.BuildConfig
import com.dkexception.core.base.BaseAPIClient
import com.dkexception.core.model.AirVisualAPIError
import com.dkexception.core.model.TaskResult
import com.dkexception.core.network.air_visual_api.model.air_quality.AirQualityData
import com.dkexception.core.network.air_visual_api.model.cities.GetAllCitiesResponse
import com.dkexception.core.network.air_visual_api.model.countries.GetAllCountriesResponse
import com.dkexception.core.network.air_visual_api.model.states.GetAllStatesResponse
import com.dkexception.core.wrapper.apiWrapper
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AirVisualAPIClient @Inject constructor(
    retrofitBuilder: Retrofit.Builder,
    okHttpBuilder: OkHttpClient.Builder
) : BaseAPIClient<AirVisualAPIInterface>(
    baseURL = BuildConfig.airVisualAPIBaseURL,
    apiServiceClass = AirVisualAPIInterface::class.java,
    retrofitBuilder = retrofitBuilder,
    okHttpClientBuilder = okHttpBuilder
) {

    private val apiKey: String by lazy {
        BuildConfig.airVisualAPIKey
    }

    suspend fun getAllCountries(): TaskResult<GetAllCountriesResponse, AirVisualAPIError> =
        apiWrapper {
            apiService.getAllCountries(apiKey = apiKey)
        }

    suspend fun getAllStatesInCountry(
        country: String
    ): TaskResult<GetAllStatesResponse, AirVisualAPIError> = apiWrapper {
        apiService.getAllStatesInCountry(
            apiKey = apiKey,
            country = country
        )
    }

    suspend fun getAllCitiesInState(
        country: String,
        state: String
    ): TaskResult<GetAllCitiesResponse, AirVisualAPIError> = apiWrapper {
        apiService.getAllCitiesInState(
            apiKey = apiKey,
            country = country,
            state = state
        )
    }

    suspend fun getAirQualityByIPLocation(
        targetIPAddress: String? = null
    ): TaskResult<AirQualityData, AirVisualAPIError> = apiWrapper {
        apiService.getAirQualityByIPLocation(
            apiKey = apiKey,
            targetIPAddress = targetIPAddress
        )
    }

    suspend fun getAirQualityByLocationCoordinates(
        latitude: Double,
        longitude: Double
    ): TaskResult<AirQualityData, AirVisualAPIError> = apiWrapper {
        apiService.getAirQualityByLocationCoordinates(
            apiKey = apiKey,
            latitude = latitude,
            longitude = longitude
        )
    }

    suspend fun getAirQualityByCity(
        country: String,
        state: String,
        city: String
    ): TaskResult<AirQualityData, AirVisualAPIError> = apiWrapper {
        apiService.getAirQualityByCity(
            apiKey = apiKey,
            country = country,
            state = state,
            city = city
        )
    }
}
