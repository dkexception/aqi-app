package com.dkexception.core.network.air_visual_api

import com.dkexception.core.base.BaseAPIInterface
import com.dkexception.core.base.BaseAPIResponse
import com.dkexception.core.network.air_visual_api.model.air_quality.AirQualityData
import com.dkexception.core.network.air_visual_api.model.cities.GetAllCitiesResponse
import com.dkexception.core.network.air_visual_api.model.countries.GetAllCountriesResponse
import com.dkexception.core.network.air_visual_api.model.states.GetAllStatesResponse
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface AirVisualAPIInterface : BaseAPIInterface {

    @GET("v2/countries")
    suspend fun getAllCountries(
        @Query("key") apiKey: String
    ): BaseAPIResponse<GetAllCountriesResponse>?

    @GET("v2/states")
    suspend fun getAllStatesInCountry(
        @Query("key") apiKey: String,
        @Query("country") country: String
    ): BaseAPIResponse<GetAllStatesResponse>?

    @GET("v2/cities")
    suspend fun getAllCitiesInState(
        @Query("key") apiKey: String,
        @Query("country") country: String,
        @Query("state") state: String
    ): BaseAPIResponse<GetAllCitiesResponse>?

    @GET("v2/nearest_city")
    suspend fun getAirQualityByIPLocation(
        @Query("key") apiKey: String,
        @Header("x-forwarded-for") targetIPAddress: String? = null
    ): BaseAPIResponse<AirQualityData>?

    @GET("v2/nearest_city")
    suspend fun getAirQualityByLocationCoordinates(
        @Query("key") apiKey: String,
        @Query("lat") latitude: Double,
        @Query("lon") longitude: Double
    ): BaseAPIResponse<AirQualityData>?

    @GET("v2/city")
    suspend fun getAirQualityByCity(
        @Query("key") apiKey: String,
        @Query("country") country: String,
        @Query("state") state: String,
        @Query("city") city: String
    ): BaseAPIResponse<AirQualityData>?
}
