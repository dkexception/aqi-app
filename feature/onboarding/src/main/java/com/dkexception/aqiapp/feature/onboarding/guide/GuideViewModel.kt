package com.dkexception.aqiapp.feature.onboarding.guide

import com.dkexception.core.DataStore
import com.dkexception.core.base.mvi.BaseScreenState
import com.dkexception.core.base.mvi.BaseViewModel
import com.dkexception.core.navigation.NavRoute
import com.dkexception.core.utils.Constants
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

@HiltViewModel
class GuideViewModel @Inject constructor(
    dataStore: DataStore
) : BaseViewModel<GuideEvent, BaseScreenState>() {

    private val isUserAuthenticated: Boolean = dataStore.getBoolean(
        key = Constants.SP_KEY_USER_AUTHENTICATED,
        default = false
    )

    override val mState: MutableStateFlow<BaseScreenState> = MutableStateFlow(BaseScreenState())

    override fun onEvent(event: GuideEvent) {
        when (event) {

            GuideEvent.OnGetStartedClicked -> navigateNext()

            GuideEvent.OnSkipClicked -> navigateNext()
        }
    }

    private fun navigateNext() = navigationManager.navigate(
        if (isUserAuthenticated) {
            NavRoute.DASHBOARD.ROOT
        } else {
            NavRoute.AUTH.ROOT
        }
    )
}
