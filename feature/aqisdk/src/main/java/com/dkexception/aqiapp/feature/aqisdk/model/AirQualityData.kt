package com.dkexception.aqiapp.feature.aqisdk.model

data class AirQualityData(

    val isFromIPLocation: Boolean = true,

    val chinaLevel: AQILevel = AQILevel.UNKNOWN,
    val americaLevel: AQILevel = AQILevel.UNKNOWN,

    val city: String? = null,
    val state: String? = null,
    val country: String? = null,

    val latLng: Pair<Double, Double>? = null,

    val pollutionData: PollutionData = PollutionData(),
    val weatherData: WeatherData = WeatherData()
)

enum class AQILevel {

    UNKNOWN,
    GOOD,
    MODERATE,
    BAD,
    POOR,
    UNHEALTHY,
    HAZARDOUS
}

data class PollutionData(

    val aqiChinaMEP: Int? = null,
    val mainPollutantChina: String? = null,

    val aqiAmericaEPA: Int? = null,
    val mainPollutantAmerica: String? = null,

    val timestamp: String = System.currentTimeMillis().toString()
)

data class WeatherData(

    val humidityPercent: Double? = null,
    val weatherIconUrl: String = "",
    val pressureHPA: Double? = null,
    val temperature: Double? = null,
    val windDirectionAngle: Double? = null,
    val windSpeedMPS: Double? = null,
    val timestamp: String = System.currentTimeMillis().toString()
)
