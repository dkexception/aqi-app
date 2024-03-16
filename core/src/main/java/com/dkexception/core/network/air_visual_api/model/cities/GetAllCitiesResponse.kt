package com.dkexception.core.network.air_visual_api.model.cities

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
class GetAllCitiesResponse : ArrayList<CityData>()

@Keep
data class CityData(

    @SerializedName("city")
    val city: String
)
