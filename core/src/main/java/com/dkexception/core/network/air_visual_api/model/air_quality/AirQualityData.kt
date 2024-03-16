package com.dkexception.core.network.air_visual_api.model.air_quality

import com.google.gson.annotations.SerializedName

data class AirQualityData(
    @SerializedName("city")
    val city: String? = null,
    @SerializedName("country")
    val country: String? = null,
    @SerializedName("current")
    val current: Current? = null,
    @SerializedName("forecasts")
    val forecasts: List<Forecast>? = null,
    @SerializedName("history")
    val history: History? = null,
    @SerializedName("location")
    val location: Location? = null,
    @SerializedName("state")
    val state: String? = null
)

data class Current(
    @SerializedName("pollution")
    val pollution: Pollution? = null,
    @SerializedName("weather")
    val weather: Weather? = null
)

data class Pollution(
    @SerializedName("aqicn")
    val aqicn: Int? = null,
    @SerializedName("aqius")
    val aqius: Int? = null,
    @SerializedName("maincn")
    val maincn: String? = null,
    @SerializedName("mainus")
    val mainus: String? = null,
    @SerializedName("p2")
    val p2: P2? = null,
    @SerializedName("ts")
    val ts: String? = null
)

data class P2(
    @SerializedName("aqicn")
    val aqicn: Int? = null,
    @SerializedName("aqius")
    val aqius: Int? = null,
    @SerializedName("conc")
    val conc: Double? = null
)

data class Weather(
    @SerializedName("hu")
    val hu: Double? = null,
    @SerializedName("ic")
    val ic: String? = null,
    @SerializedName("pr")
    val pr: Double? = null,
    @SerializedName("tp")
    val tp: Double? = null,
    @SerializedName("ts")
    val ts: String? = null,
    @SerializedName("wd")
    val wd: Double? = null,
    @SerializedName("ws")
    val ws: Double? = null
)

data class Forecast(
    @SerializedName("aqicn")
    val aqicn: Int? = null,
    @SerializedName("aqius")
    val aqius: Int? = null,
    @SerializedName("hu")
    val hu: Int? = null,
    @SerializedName("ic")
    val ic: String? = null,
    @SerializedName("pr")
    val pr: Int? = null,
    @SerializedName("tp")
    val tp: Int? = null,
    @SerializedName("tp_min")
    val tpMin: Int? = null,
    @SerializedName("ts")
    val ts: String? = null,
    @SerializedName("wd")
    val wd: Int? = null,
    @SerializedName("ws")
    val ws: Int? = null
)

data class History(
    @SerializedName("pollution")
    val pollution: List<PollutionX>? = null,
    @SerializedName("weather")
    val weather: List<Weather>? = null
)

data class PollutionX(
    @SerializedName("aqicn")
    val aqicn: Int? = null,
    @SerializedName("aqius")
    val aqius: Int? = null,
    @SerializedName("maincn")
    val maincn: String? = null,
    @SerializedName("mainus")
    val mainus: String? = null,
    @SerializedName("p2")
    val p2: P2? = null,
    @SerializedName("ts")
    val ts: String? = null
)

data class Location(
    @SerializedName("coordinates")
    val coordinates: List<Double?>? = null,
    @SerializedName("type")
    val type: String? = null
)
