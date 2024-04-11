package com.dkexception.core.model.profile

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class AuthUserData(

    @SerializedName("name")
    val name: String,

    @SerializedName("emailId")
    val emailId: String
)
