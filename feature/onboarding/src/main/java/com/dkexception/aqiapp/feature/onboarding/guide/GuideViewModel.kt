package com.dkexception.aqiapp.feature.onboarding.guide

import com.dkexception.core.DataStore
import com.dkexception.core.base.mvi.BaseViewModel
import com.dkexception.core.navigation.NavRoute
import com.dkexception.core.utils.Constants
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class GuideViewModel @Inject constructor(
    private val dataStore: DataStore
) : BaseViewModel<GuideEvent>() {

    private val isUserAuthenticated: Boolean = dataStore.containsKey(
        key = Constants.SP_KEY_USER_DATA
    )

    override fun onEvent(event: GuideEvent) {
        when (event) {

            GuideEvent.OnGetStartedClicked -> navigateNext()

            GuideEvent.OnSkipClicked -> navigateNext()
        }
    }

    private fun navigateNext() {

        // Set user seen onboarding
        dataStore.saveBoolean(
            key = Constants.SP_KEY_ONBOARDING_DONE,
            value = true
        )

        // And navigate further
        if (isUserAuthenticated) {
            navigationManager.navigateClearingStack(NavRoute.HOME.ROOT)
        } else {
            navigationManager.navigate(NavRoute.AUTH.ROOT)
        }
    }
}
