package com.dkexception.core.model

sealed interface Error

enum class AirVisualAPIError : Error {

    NoInternetError,

    CallLimitReachedError,

    APIKeyExhausted,

    APIKeyError,

    PlaceNotFoundError,

    NoNearbyStationError,

    FeatureNotAvailableError,

    TooManyRequestsError,

    InvalidBackendResponseError,

    Unknown
}
