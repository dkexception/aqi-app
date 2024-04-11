package com.dkexception.aqiapp.feature.databank.main

import androidx.lifecycle.viewModelScope
import com.dkexception.core.base.mvi.BaseViewModel
import com.dkexception.core.model.EmailValidationError
import com.dkexception.core.model.UIText
import com.dkexception.core.model.errorOrNull
import com.dkexception.core.validators.ISingleStringValidator
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
class DataBankMainViewModel @Inject constructor(
    @Named("email") private val emailValidator: ISingleStringValidator
) : BaseViewModel<DataBankMainEvent>() {

    private val _state = MutableStateFlow(DataBankMainScreenState())
    val state: StateFlow<DataBankMainScreenState>
        get() = _state.map {

            val emailError: EmailValidationError? =
                (emailValidator(it.enteredEmailId).errorOrNull as? EmailValidationError)

            val uiEmailError: UIText? = when (emailError) {
                EmailValidationError.INCORRECT -> UIText.DynamicString("Please enter a valid email!")
                else -> null
            }

            val shouldEnableMakeRequestButton: Boolean = uiEmailError == null

            it.copy(
                isMakeRequestButtonEnabled = shouldEnableMakeRequestButton,
                emailIdError = uiEmailError
            )

        }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(), DataBankMainScreenState())

    override fun onEvent(event: DataBankMainEvent) {
        when (event) {
            is DataBankMainEvent.OnCityChanged -> {
                _state.update {
                    it.copy(
                        enteredCity = event.newCity
                    )
                }
            }

            is DataBankMainEvent.OnDateChanged -> {
                _state.update {
                    it.copy(
                        selectedDate = event.newDate
                    )
                }
            }

            is DataBankMainEvent.OnEmailChanged -> {
                _state.update {
                    it.copy(
                        enteredEmailId = event.newEmail
                    )
                }
            }

            DataBankMainEvent.OnMakeRequestButtonClicked -> {
                // Show Snackbar something
            }
        }
    }
}
