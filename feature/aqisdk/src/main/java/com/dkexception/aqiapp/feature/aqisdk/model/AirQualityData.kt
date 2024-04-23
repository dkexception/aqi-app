package com.dkexception.aqiapp.feature.aqisdk.model

data class AirQualityData(

    val isDefault: Boolean = true,

    val isFromIPLocation: Boolean = true,

    val chinaLevel: AQILevel = AQILevel.UNKNOWN,
    val americaLevel: AQILevel = AQILevel.UNKNOWN,

    val city: String? = null,
    val state: String? = null,
    val country: String? = null,

    val latLng: Pair<Double, Double>? = null,

    val pollutionData: PollutionData = PollutionData(),
    val weatherData: WeatherData = WeatherData()
) {

    companion object {

        val PREVIEW_DATA = AirQualityData(
            isFromIPLocation = true,
            chinaLevel = AQILevel.MODERATE,
            americaLevel = AQILevel.GOOD,
            city = "Pune",
            state = "Maharashtra",
            country = "India",
            latLng = 18.64 to 73.84,
            pollutionData = PollutionData(
                aqiChinaMEP = 80,
                mainPollutantChina = "p2",
                aqiAmericaEPA = 153,
                mainPollutantAmerica = "p2",
                timestamp = "2024-04-12T07:00:00.000Z"
            ),
            weatherData = WeatherData(
                humidityPercent = 21.0,
                weatherIconUrl = "https://airvisual.com/images/04d.png",
                pressureHPA = 1010.0,
                temperature = 35.0,
                windDirectionAngle = 160.0,
                windSpeedMPS = 3.03,
                timestamp = "2024-04-12T08:00:00.000Z"
            )
        )
    }
}

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
