package com.dkexception.aqiapp.feature.aqisdk.network.model.states

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
internal class GetAllStatesResponse : ArrayList<StateData>()

@Keep
internal data class StateData(

    @SerializedName("state")
    val state: String
)
