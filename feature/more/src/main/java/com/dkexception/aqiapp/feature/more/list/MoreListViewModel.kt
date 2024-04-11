package com.dkexception.aqiapp.feature.more.list

import com.dkexception.core.DataStore
import com.dkexception.core.base.mvi.BaseViewModel
import com.dkexception.core.environment.IEnvironment
import com.dkexception.core.model.profile.AuthUserData
import com.dkexception.core.navigation.NavRoute
import com.dkexception.core.utils.Constants
import com.google.gson.Gson
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class MoreListViewModel @Inject constructor(
    mEnvironment: IEnvironment,
    dataStore: DataStore
) : BaseViewModel<MoreListEvent>() {

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
        MoreListScreenState(
            userName = authUserData?.name.takeUnless { it.isNullOrBlank() } ?: "User",
            emailId = authUserData?.emailId.orEmpty(),
            appName = mEnvironment.appName,
            appVersion = mEnvironment.version
        )
    )
    val state: StateFlow<MoreListScreenState> get() = _state.asStateFlow()

    override fun onEvent(event: MoreListEvent) {
        when (event) {
            is MoreListEvent.OnItemClicked -> {
                when (event.item) {
                    MoreListItem.PROFILE -> {

                    }

                    MoreListItem.SAVED_LOCATIONS -> {

                    }

                    MoreListItem.FAQ -> {
                        navigationManager.navigate(NavRoute.DETAILS.AQI_SCALE)
                    }

                    MoreListItem.SETTINGS -> {

                    }

                    MoreListItem.ABOUT_US -> {

                    }

                    MoreListItem.CONTACT_US -> {

                    }

                    MoreListItem.LOGOUT -> {

                    }
                }
            }
        }
    }
}
