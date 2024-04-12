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

    NullResponseError,

    UnknownError
}

enum class PasswordValidationError : Error {

    EMPTY,

    TOO_SHORT,

    TOO_SIMPLE
}

enum class EmailValidationError : Error {

    EMPTY,

    INCORRECT
}
