package com.dkexception.aqiapp.feature.auth.login

data class LoginScreenState(

    val enteredEmailId: String = "",

    val enteredPassword: String = "",

    val isLoginButtonEnabled: Boolean = false
)
