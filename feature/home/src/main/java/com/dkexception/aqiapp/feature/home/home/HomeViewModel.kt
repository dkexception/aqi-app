package com.dkexception.aqiapp.feature.home.home

import androidx.lifecycle.viewModelScope
import com.dkexception.aqiapp.feature.aqidetails.contract.IAQIDetailsCard
import com.dkexception.aqiapp.feature.aqisdk.contract.IAirVisualDataManager
import com.dkexception.core.DataStore
import com.dkexception.core.base.mvi.BaseViewModel
import com.dkexception.core.model.profile.AuthUserData
import com.dkexception.core.navigation.NavRoute
import com.dkexception.core.utils.Constants
import com.google.gson.Gson
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    dataStore: DataStore,
    val aqiIAQIDetailsCard: IAQIDetailsCard,
    private val manager: IAirVisualDataManager
) : BaseViewModel<HomeEvent>() {

    private val authUserData: AuthUserData? = try {

        val userDataContent: String? = dataStore.getString(
            key = Constants.SP_KEY_USER_DATA
        )

        userDataContent?.let {
            Gson().fromJson(it, AuthUserData::class.java)
        }
    } catch (e: Exception) {
        null
    }

    private val _state = MutableStateFlow(
        HomeScreenState(
            userName = authUserData?.name ?: "User"
        )
    )
    val state: StateFlow<HomeScreenState> get() = _state.asStateFlow()

    init {
        setUpSDK()
    }

    override fun onEvent(event: HomeEvent) {
        when (event) {
            HomeEvent.OnPulledToRefresh -> manager.getDataByIPLocation()
            HomeEvent.OnAQICardClicked -> {
                navigationManager.navigate(
                    "${NavRoute.DETAILS.AQI_DETAILS}?shouldUseIPLocation=${state.value.aqiData?.isFromIPLocation ?: true}"
                )
            }
        }
    }

    private fun setUpSDK() = viewModelScope.launch {

        manager.initialise()
        manager.getDataByIPLocation()
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
