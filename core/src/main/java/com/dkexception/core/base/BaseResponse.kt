package com.dkexception.core.base

import androidx.annotation.Keep
import com.dkexception.core.model.AirVisualAPIError
import com.dkexception.core.model.TaskResult
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

    fun <D> toErrorResult(
        httpStatusCode: Int
    ): TaskResult.Error<D, AirVisualAPIError> = when (httpStatusCode) {

        // Too many requests
        429 -> TaskResult.Error(AirVisualAPIError.TooManyRequestsError)

        // Incorrect or exhausted API key
        HttpURLConnection.HTTP_FORBIDDEN -> TaskResult.Error(
            AirVisualAPIError.APIKeyError
        )

        // Bad request
        HttpURLConnection.HTTP_BAD_REQUEST -> {

            val errorMessage = errorData?.message.orEmpty()

            when {
                errorMessage.contains("incorrect_api_key", true) -> {

                    TaskResult.Error(AirVisualAPIError.APIKeyError)

                }

                errorMessage.contains("permission_denied", true) -> {

                    TaskResult.Error(AirVisualAPIError.FeatureNotAvailableError)

                }

                errorMessage.contains("city_not_found", true) -> {

                    TaskResult.Error(AirVisualAPIError.PlaceNotFoundError)

                }

                else -> {

                    TaskResult.Error(AirVisualAPIError.UnknownError)
                }
            }
        }

        // Generic failure
        else -> TaskResult.Error(AirVisualAPIError.UnknownError)
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
