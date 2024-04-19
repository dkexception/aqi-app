package com.dkexception.aqiapp.feature.aqidetails.contract

import androidx.compose.runtime.Composable
import com.dkexception.aqiapp.feature.aqisdk.model.AirQualityData

fun interface IAQIDetailsCard {

    @Composable
    fun AQIDetailsCard(
        aqiData: AirQualityData,
        onCardClicked: () -> Unit
    )
}
