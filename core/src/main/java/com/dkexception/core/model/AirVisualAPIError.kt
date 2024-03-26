package com.dkexception.core.model

sealed interface Error

enum class AirVisualAPIError : Error {

    NoInternetError,

    CallLimitReachedError,

    APIKeyExhaustedError,

    APIKeyError,

    PlaceNotFoundError,

    NoNearbyStationError,

    FeatureNotAvailableError,

    TooManyRequestsError,

    InvalidBackendResponseError,

    UnknownError
}
