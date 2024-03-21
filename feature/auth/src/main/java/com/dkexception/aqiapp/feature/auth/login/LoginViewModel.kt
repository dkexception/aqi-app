package com.dkexception.aqiapp.feature.auth.login

import com.dkexception.core.DataStore
import com.dkexception.core.base.mvi.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val dataStore: DataStore
) : BaseViewModel<LoginEvent, LoginState>() {

    override val mState: MutableStateFlow<LoginState> = MutableStateFlow(LoginState())

    override fun onEvent(event: LoginEvent) {
        when (event) {
            is LoginEvent.OnEmailChanged -> TODO()
            is LoginEvent.OnPasswordChanged -> TODO()
            LoginEvent.OnLoginClicked -> TODO()
        }
    }
}
