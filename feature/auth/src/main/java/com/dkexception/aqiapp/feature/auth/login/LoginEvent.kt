package com.dkexception.aqiapp.feature.auth.login

sealed class LoginEvent {

    data class OnEmailChanged(val newEmailId: String) : LoginEvent()

    data class OnPasswordChanged(val newPassword: String) : LoginEvent()

    data object OnLoginClicked : LoginEvent()
}
