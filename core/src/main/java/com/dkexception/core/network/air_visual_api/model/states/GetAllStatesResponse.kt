package com.dkexception.core.network.air_visual_api.model.states

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
class GetAllStatesResponse : ArrayList<StateData>()

@Keep
data class StateData(

    @SerializedName("state")
    val state: String
)
