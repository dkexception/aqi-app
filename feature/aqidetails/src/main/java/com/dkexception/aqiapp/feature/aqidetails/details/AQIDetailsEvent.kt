package com.dkexception.aqiapp.feature.aqidetails.details

sealed class AQIDetailsEvent {

    data object OnPulledToRefresh : AQIDetailsEvent()
}
