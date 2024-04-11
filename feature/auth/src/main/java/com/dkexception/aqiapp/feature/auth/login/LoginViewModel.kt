package com.dkexception.aqiapp.feature.auth.login

import androidx.lifecycle.viewModelScope
import com.dkexception.core.DataStore
import com.dkexception.core.base.mvi.BaseViewModel
import com.dkexception.core.model.EmailValidationError
import com.dkexception.core.model.PasswordValidationError
import com.dkexception.core.model.UIText
import com.dkexception.core.model.errorOrNull
import com.dkexception.core.model.profile.AuthUserData
import com.dkexception.core.navigation.NavRoute
import com.dkexception.core.utils.Constants
import com.dkexception.core.validators.ISingleStringValidator
import com.google.gson.Gson
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import javax.inject.Inject
import javax.inject.Named

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val dataStore: DataStore,
    @Named("email") private val emailValidator: ISingleStringValidator,
    @Named("password") private val passwordValidator: ISingleStringValidator
) : BaseViewModel<LoginEvent>() {

    private val _state = MutableStateFlow(LoginScreenState())
    val state: StateFlow<LoginScreenState>
        get() = _state.map {

            val emailError: EmailValidationError? =
                (emailValidator(it.enteredEmailId).errorOrNull as? EmailValidationError)

            val uiEmailError: UIText? = when (emailError) {
                EmailValidationError.INCORRECT -> UIText.DynamicString("Please enter a valid email!")
                else -> null
            }

            val passwordError: PasswordValidationError? =
                (passwordValidator(it.enteredPassword).errorOrNull as? PasswordValidationError)

            val uiPasswordError: UIText? = when (passwordError) {
                PasswordValidationError.TOO_SHORT -> UIText.DynamicString("Password too short!")
                PasswordValidationError.TOO_SIMPLE -> UIText.DynamicString("Password too simple!")
                else -> null
            }

            val shouldEnableLoginButton: Boolean = uiEmailError == null
                    && uiPasswordError == null
                    && it.enteredEmailId.isNotBlank()
                    && it.enteredPassword.isNotBlank()
                    && it.enteredName.isNotBlank()

            it.copy(
                isLoginButtonEnabled = shouldEnableLoginButton,
                emailIdError = uiEmailError,
                passwordError = uiPasswordError
            )
        }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(), LoginScreenState())

    override fun onEvent(event: LoginEvent) {
        when (event) {

            is LoginEvent.OnNameChanged -> {
                _state.update {
                    it.copy(
                        enteredName = event.newName
                    )
                }
            }

            is LoginEvent.OnEmailChanged -> {
                _state.update {
                    it.copy(
                        enteredEmailId = event.newEmailId
                    )
                }
            }

            is LoginEvent.OnPasswordChanged -> {
                _state.update {
                    it.copy(
                        enteredPassword = event.newPassword
                    )
                }
            }

            LoginEvent.OnLoginClicked -> {

                // Set user logged in by saving the auth data
                dataStore.saveString(
                    key = Constants.SP_KEY_USER_DATA,
                    value = Gson().toJson(
                        AuthUserData(
                            name = _state.value.enteredName,
                            emailId = _state.value.enteredEmailId
                        )
                    )
                )

                // And navigate to the dashboard
                navigationManager.navigateClearingStack(NavRoute.HOME.ROOT)
            }
        }
    }
}
