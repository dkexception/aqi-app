package com.dkexception.aqiapp.feature.aqidetails.scale

sealed class AQIScaleEvent {

    data object OnBackClicked : AQIScaleEvent()
}
