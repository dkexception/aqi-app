package com.dkexception.aqiapp.feature.home.home

import com.dkexception.core.base.mvi.BaseViewModel
import com.dkexception.ui.maps.IMapView
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    val mMapView: IMapView
) : BaseViewModel<HomeEvent>() {

    private val _state = MutableStateFlow(HomeScreenState())
    val state: StateFlow<HomeScreenState> get() = _state.asStateFlow()

//    override fun onEvent(event: HomeEvent) {
//        when (event) {
//
//        }
//    }
}
