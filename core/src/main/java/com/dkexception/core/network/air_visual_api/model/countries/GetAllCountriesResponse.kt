package com.dkexception.core.network.air_visual_api.model.countries

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
class GetAllCountriesResponse : ArrayList<CountryData>()

@Keep
data class CountryData(

    @SerializedName("country")
    val country: String
)
