package com.dkexception.aqiapp.feature.home.home

sealed class HomeEvent {

    data object OnPulledToRefresh : HomeEvent()

    data object OnAQICardClicked : HomeEvent()
}
