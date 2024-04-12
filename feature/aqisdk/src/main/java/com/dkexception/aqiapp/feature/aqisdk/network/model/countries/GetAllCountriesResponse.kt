package com.dkexception.aqiapp.feature.aqisdk.network.model.countries

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
internal class GetAllCountriesResponse : ArrayList<CountryData>()

@Keep
internal data class CountryData(

    @SerializedName("country")
    val country: String
)
