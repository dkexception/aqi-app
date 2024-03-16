package com.dkexception.core.wrapper

import com.dkexception.core.base.BaseAPIErrorResponse
import com.dkexception.core.base.BaseAPIResponse
import com.dkexception.core.model.AQIAppException
import com.dkexception.core.model.TaskResult
import retrofit2.HttpException
import java.net.ConnectException
import java.net.UnknownHostException

internal suspend fun <T> apiWrapper(
    apiBlock: suspend () -> BaseAPIResponse<T>?
): TaskResult<T> = try {

    // Actual API call
    val response: BaseAPIResponse<T>? = apiBlock()

    if (response?.responseData == null) {
        TaskResult.Error()
    } else {
        TaskResult.Success(response.responseData)
    }
} catch (e: UnknownHostException) {

    // If something went wrong related to baseUrl
    TaskResult.Exception(AQIAppException.NoInternetException)

} catch (e: ConnectException) {

    // If something went wrong related to baseUrl
    TaskResult.Exception(AQIAppException.NoInternetException)

} catch (e: HttpException) {

    // For 4XX errors, check and return the error cause
    BaseAPIErrorResponse.fromHttpException(e).toErrorResult(e.code())

} catch (e: Exception) {

    // Generic exceptions
    TaskResult.Exception(exception = AQIAppException.GenericException(e))
}
