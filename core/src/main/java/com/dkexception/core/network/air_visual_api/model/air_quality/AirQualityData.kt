package com.dkexception.core.network.air_visual_api.model.air_quality

import com.google.gson.annotations.SerializedName

data class AirQualityData(

    @SerializedName("city")
    val city: String? = null,
    @SerializedName("state")
    val state: String? = null,
    @SerializedName("country")
    val country: String? = null,
    @SerializedName("location")
    val location: Location? = null,

    @SerializedName("current")
    val current: Current? = null
)

data class Location(
    @SerializedName("coordinates")
    val coordinates: List<Double>? = null,
    @SerializedName("type")
    val type: String? = null
)

data class Current(
    @SerializedName("pollution")
    val pollution: Pollution? = null,
    @SerializedName("weather")
    val weather: Weather? = null
)

data class Pollution(

    @SerializedName("aqicn")
    val aqiChinaMEP: Int? = null,
    @SerializedName("aqius")
    val aqiAmericaEPA: Int? = null,
    @SerializedName("maincn")
    val mainPollutantChina: String? = null,
    @SerializedName("mainus")
    val mainPollutantAmerica: String? = null,
    @SerializedName("ts")
    val timestamp: String? = null,

    @SerializedName("p1")
    val pm10: PrimaryPollutant? = null,
    @SerializedName("p2")
    val p25: PrimaryPollutant? = null,
    @SerializedName("o3")
    val ozone: PrimaryPollutant? = null,
    @SerializedName("n2")
    val nitrogenDioxide: PrimaryPollutant? = null,
    @SerializedName("s2")
    val sulphurDioxide: PrimaryPollutant? = null,
    @SerializedName("co")
    val carbonMonoxide: PrimaryPollutant? = null
)

data class PrimaryPollutant(
    @SerializedName("aqicn")
    val aqiChinaMEP: Int? = null,
    @SerializedName("aqius")
    val aqiAmericaEPA: Int? = null,
    @SerializedName("conc")
    val concentration: Double? = null
)

data class Weather(
    @SerializedName("hu")
    val humidityPercent: Double? = null,
    @SerializedName("ic")
    val weatherIcon: String? = null,
    @SerializedName("pr")
    val pressureHPA: Double? = null,
    @SerializedName("tp")
    val temperature: Double? = null,
    @SerializedName("ts")
    val timestamp: String? = null,
    @SerializedName("wd")
    val windDirectionAngle: Double? = null,
    @SerializedName("ws")
    val windSpeedMPS: Double? = null
)
