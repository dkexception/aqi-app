package com.dkexception.aqiapp.feature.aqisdk.mapper

import com.dkexception.aqiapp.feature.aqisdk.model.AQILevel
import com.dkexception.aqiapp.feature.aqisdk.model.AirQualityData
import com.dkexception.aqiapp.feature.aqisdk.model.PollutionData
import com.dkexception.aqiapp.feature.aqisdk.model.WeatherData
import com.dkexception.aqiapp.feature.aqisdk.network.model.air_quality.AirQualityResponse

internal fun AirQualityResponse.toAirQualityData(
    isFromIPLocation: Boolean
): AirQualityData {

    val latitude = this.location?.coordinates?.getOrNull(1) ?: 0.0
    val longitude = this.location?.coordinates?.getOrNull(0) ?: 0.0

    val aqiLevelAsPerChina = this.current?.pollution?.aqiChinaMEP
    val aqiLevelAsPerAmerica = this.current?.pollution?.aqiAmericaEPA

    val weatherIcon = this.current?.weather?.weatherIcon ?: "01d"

    val weatherIconUrl = "https://airvisual.com/images/$weatherIcon.png"

    return AirQualityData(
        isDefault = false,
        isFromIPLocation = isFromIPLocation,
        chinaLevel = aqiLevelAsPerChina.toAQILevel(),
        americaLevel = aqiLevelAsPerAmerica.toAQILevel(),
        city = this.city,
        state = this.state,
        country = this.country,
        latLng = latitude to longitude,
        pollutionData = PollutionData(
            aqiChinaMEP = this.current?.pollution?.aqiChinaMEP,
            mainPollutantChina = this.current?.pollution?.mainPollutantChina,
            aqiAmericaEPA = this.current?.pollution?.aqiAmericaEPA,
            mainPollutantAmerica = this.current?.pollution?.mainPollutantAmerica,
            timestamp = this.current?.pollution?.timestamp ?: System.currentTimeMillis().toString()
        ),
        weatherData = WeatherData(
            humidityPercent = this.current?.weather?.humidityPercent,
            weatherIconUrl = weatherIconUrl,
            pressureHPA = this.current?.weather?.pressureHPA,
            temperature = this.current?.weather?.temperature,
            windDirectionAngle = this.current?.weather?.windDirectionAngle,
            windSpeedMPS = this.current?.weather?.windSpeedMPS,
            timestamp = this.current?.weather?.timestamp ?: System.currentTimeMillis().toString()
        )
    )
}

private fun Int?.toAQILevel(): AQILevel {

    this ?: return AQILevel.UNKNOWN

    return when {
        this < 0 -> AQILevel.UNKNOWN
        this <= 50 -> AQILevel.GOOD
        this <= 100 -> AQILevel.MODERATE
        this <= 150 -> AQILevel.BAD
        this <= 200 -> AQILevel.POOR
        this <= 300 -> AQILevel.UNHEALTHY
        this <= 500 -> AQILevel.HAZARDOUS
        else -> AQILevel.UNKNOWN
    }
}
