package com.dkexception.aqiapp.feature.onboarding.welcome

import androidx.lifecycle.viewModelScope
import androidx.navigation.navOptions
import com.dkexception.core.DataStore
import com.dkexception.core.base.mvi.BaseScreenEvent
import com.dkexception.core.base.mvi.BaseScreenState
import com.dkexception.core.base.mvi.BaseViewModel
import com.dkexception.core.navigation.NavRoute
import com.dkexception.core.utils.Constants
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WelcomeViewModel @Inject constructor(
    dataStore: DataStore
) : BaseViewModel<BaseScreenEvent, BaseScreenState>() {

    private val isUserOnboarded: Boolean = dataStore.getBoolean(
        key = Constants.SP_KEY_ONBOARDING_DONE,
        default = false
    )

    private val isUserAuthenticated: Boolean = dataStore.getBoolean(
        key = Constants.SP_KEY_USER_AUTHENTICATED,
        default = false
    )

    override val mState: MutableStateFlow<BaseScreenState> = MutableStateFlow(BaseScreenState())

    init {
        navigateNext()
    }

    private fun navigateNext() = viewModelScope.launch {

        delay(1000)

        val nextRoute = when {
            isUserAuthenticated -> {
                NavRoute.DASHBOARD.ROOT
            }

            isUserOnboarded -> {
                NavRoute.AUTH.ROOT
            }

            else -> {
                NavRoute.ONBOARDING.GUIDE
            }
        }

        navigationManager.navigateWithNavOptions(
            route = nextRoute,
            navOptions = navOptions {
                popUpTo(NavRoute.ONBOARDING.ROOT) {
                    inclusive = true
                }
            }
        )
    }
}
