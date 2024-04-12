package com.dkexception.aqiapp.feature.home.home

sealed class HomeEvent {

    data object OnPulledToRefresh : HomeEvent()
}
