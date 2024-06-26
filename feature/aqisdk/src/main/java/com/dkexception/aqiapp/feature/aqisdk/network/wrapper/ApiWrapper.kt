package com.dkexception.aqiapp.feature.aqisdk.network.wrapper

import com.dkexception.core.base.BaseAPIErrorResponse
import com.dkexception.core.base.BaseAPIResponse
import com.dkexception.core.model.AirVisualAPIError
import com.dkexception.core.model.TaskResult
import retrofit2.HttpException
import java.net.ConnectException
import java.net.UnknownHostException

internal suspend fun <D> apiWrapper(
    apiBlock: suspend () -> BaseAPIResponse<D>?
): TaskResult<D, AirVisualAPIError> = try {

    // Actual API call
    val response: BaseAPIResponse<D>? = apiBlock()

    // Result based on non nullity
    response?.responseData?.let {
        TaskResult.Success(it)
    } ?: TaskResult.Error(AirVisualAPIError.NullResponseError)
} catch (e: UnknownHostException) {

    // If something went wrong related to baseUrl
    TaskResult.Error(AirVisualAPIError.NoInternetError)

} catch (e: ConnectException) {

    // If something went wrong related to baseUrl
    TaskResult.Error(AirVisualAPIError.NoInternetError)

} catch (e: HttpException) {

    // For 4XX errors, check and return the error cause
    BaseAPIErrorResponse.fromHttpException(e).toErrorResult(e.code())

} catch (e: Exception) {

    // Generic exceptions
    TaskResult.Error(AirVisualAPIError.UnknownError)
}
