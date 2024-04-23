package com.dkexception.aqiapp.feature.aqidetails.details

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.dkexception.aqiapp.feature.aqisdk.contract.IAirVisualDataManager
import com.dkexception.core.base.mvi.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AQIDetailsViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val manager: IAirVisualDataManager
) : BaseViewModel<AQIDetailsEvent>() {

    private val shouldUseIPLocation: Boolean = savedStateHandle["shouldUseIPLocation"] ?: false

    private val _state = MutableStateFlow(AQIDetailsScreenState())
    val state: StateFlow<AQIDetailsScreenState> get() = _state.asStateFlow()

    init {
        if (shouldUseIPLocation) {
            observeIPLocationData()
        }
    }

    override fun onEvent(event: AQIDetailsEvent) = Unit

    private fun observeIPLocationData() = viewModelScope.launch {
        manager.ipLocationData.collect { (isLoading, aqiData) ->

            _state.update {
                it.copy(
                    isLoading = isLoading,
                    aqiData = aqiData
                )
            }
        }
    }
}
