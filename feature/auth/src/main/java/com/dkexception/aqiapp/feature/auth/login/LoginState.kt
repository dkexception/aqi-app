package com.dkexception.aqiapp.feature.auth.login

data class LoginState(

    val enteredEmailId: String = "",

    val enteredPassword: String = "",

    val isLoginButtonEnabled: Boolean = false
)
