package com.dkexception.core.model

/**
 * Serves as a container for any API or non-API requests. If wrapped around the responses,
 * makes it easier to handle errors and success scenarios differently.
 *
 * @param data the data to expect out from the wrapped Result
 * @param message optional (not necessarily) error message to be associated with
 */
sealed class TaskResult<T>(
    val data: T? = null,
    val message: UIText? = null
) {

    class Success<T>(data: T?) : TaskResult<T>(data = data)

    open class Error<T>(
        data: T? = null,
        message: UIText? = null,
        val httpStatusCode: Int? = null
    ) : TaskResult<T>(data = data, message = message)

    class Exception<T>(val exception: AQIAppException, data: T? = null) : Error<T>(
        message = exception.message.orEmpty().toUIText(),
        data = data
    )

    fun getOrNull(): T? = if (this is Success) {
        this.data
    } else {
        null
    }

    fun isSuccessful(): Boolean = this is Success && this.data != null
}
