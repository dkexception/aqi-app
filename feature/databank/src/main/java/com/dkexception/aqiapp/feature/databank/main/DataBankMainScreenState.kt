package com.dkexception.aqiapp.feature.databank.main

import com.dkexception.core.model.UIText

data class DataBankMainScreenState(

    val enteredEmailId: String = "",
    val emailIdError: UIText? = null,

    val enteredCity: String = "",

    val selectedDate: String = "",

    val isMakeRequestButtonEnabled: Boolean = false
)
