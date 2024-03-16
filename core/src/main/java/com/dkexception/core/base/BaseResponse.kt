package com.dkexception.core.base

import androidx.annotation.Keep
import com.dkexception.core.model.AQIAppException
import com.dkexception.core.model.TaskResult
import com.dkexception.core.model.UIText
import com.dkexception.core.model.toUIText
import com.google.gson.Gson
import com.google.gson.annotations.SerializedName
import retrofit2.HttpException
import java.net.HttpURLConnection

@Keep
data class BaseAPIResponse<T>(

    @SerializedName("status")
    val status: String? = null,

    @SerializedName("data")
    val responseData: T? = null
)

@Keep
data class BaseAPIErrorResponse(

    @SerializedName("status")
    val status: String? = null,

    @SerializedName("data")
    val errorData: BaseAPIError? = null
) {

    fun <T> toErrorResult(httpStatusCode: Int): TaskResult<T> = when (httpStatusCode) {

        // Too many requests
        429 -> TaskResult.Exception(AQIAppException.TooManyRequestsException)

        // Incorrect or exhausted API key
        HttpURLConnection.HTTP_FORBIDDEN -> TaskResult.Exception(
            AQIAppException.APIKeyException(
                false
            )
        )

        // Bad request
        HttpURLConnection.HTTP_BAD_REQUEST -> {

            val errorMessage = errorData?.message.orEmpty()

            when {
                errorMessage.contains("incorrect_api_key", true) -> {

                    TaskResult.Exception(AQIAppException.APIKeyException(false))

                }

                errorMessage.contains("permission_denied", true) -> {

                    TaskResult.Exception(AQIAppException.FeatureNotAvailableException)

                }

                errorMessage.contains("city_not_found", true) -> {

                    TaskResult.Exception(AQIAppException.PlaceNotFoundException)

                }

                else -> {

                    TaskResult.Exception(AQIAppException.GenericException(null))
                }
            }
        }

        // Generic failure
        else -> TaskResult.Error(
            data = null,
            message = errorData?.message?.let(String::toUIText) ?: UIText.DEFAULT_ERROR_TEXT,
            httpStatusCode = httpStatusCode
        )
    }

    companion object {

        private val DEFAULT: BaseAPIErrorResponse = BaseAPIErrorResponse(
            status = "fail",
            errorData = BaseAPIError(message = "fail")
        )

        fun fromHttpException(exception: HttpException): BaseAPIErrorResponse {

            val respString = exception.response()?.errorBody()?.string()

            val errorResponse: BaseAPIErrorResponse? = Gson().fromJson(
                respString,
                BaseAPIErrorResponse::class.java
            )

            return errorResponse ?: DEFAULT
        }
    }
}

@Keep
data class BaseAPIError(

    @SerializedName("message")
    val message: String? = null
)
