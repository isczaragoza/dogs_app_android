package com.isczaragoza.dogsapp.domain.enums

enum class NetworkError(val message: String) : BaseError {
    TIME_OUT("timeout"),
    NO_NETWORK_CONNECTION("Unable to resolve host \"jsonblob.com\": No address associated with hostname"),
    UNKNOWN_ERROR("")
}