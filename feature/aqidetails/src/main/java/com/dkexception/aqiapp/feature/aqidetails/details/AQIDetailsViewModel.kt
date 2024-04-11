package com.dkexception.aqiapp.feature.aqidetails.details

import com.dkexception.core.base.mvi.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class AQIDetailsViewModel @Inject constructor(

) : BaseViewModel<AQIDetailsEvent>() {

    private val _state = MutableStateFlow(AQIDetailsScreenState())
    val state: StateFlow<AQIDetailsScreenState> get() = _state.asStateFlow()

    override fun onEvent(event: AQIDetailsEvent) {

    }
}
