package com.dkexception.aqiapp.feature.aqisdk.network.model.cities

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
internal class GetAllCitiesResponse : ArrayList<CityData>()

@Keep
internal data class CityData(

    @SerializedName("city")
    val city: String
)
