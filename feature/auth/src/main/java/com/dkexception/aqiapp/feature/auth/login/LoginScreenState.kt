package com.dkexception.aqiapp.feature.auth.login

import com.dkexception.core.model.UIText

data class LoginScreenState(

    val enteredEmailId: String = "",
    val emailIdError: UIText? = null,

    val enteredPassword: String = "",
    val passwordError: UIText? = null,

    val isLoginButtonEnabled: Boolean = false
)
