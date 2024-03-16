package com.dkexception.core.model

@Suppress("JavaIoSerializableObjectMustHaveReadResolve")
sealed class AQIAppException : Exception() {

    data object NoInternetException : AQIAppException()

    data object CallLimitReachedException : AQIAppException()

    data class APIKeyException(val isExhausted: Boolean) : AQIAppException()

    data object PlaceNotFoundException : AQIAppException()

    data object NoNearbyStationException : AQIAppException()

    data object FeatureNotAvailableException : AQIAppException()

    data object TooManyRequestsException : AQIAppException()

    data class GenericException(
        val originalException: Exception?
    ) : AQIAppException()
}
