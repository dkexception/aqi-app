package com.dkexception.aqiapp.feature.aqidetails.scale

import com.dkexception.core.base.mvi.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class AQIScaleViewModel @Inject constructor(

) : BaseViewModel<AQIScaleEvent>() {

    private val _state = MutableStateFlow(AQIScaleScreenState())
    val state: StateFlow<AQIScaleScreenState> get() = _state.asStateFlow()

    override fun onEvent(event: AQIScaleEvent) {
        when (event) {
            AQIScaleEvent.OnBackClicked -> navigationManager.goBack()
        }
    }
}
