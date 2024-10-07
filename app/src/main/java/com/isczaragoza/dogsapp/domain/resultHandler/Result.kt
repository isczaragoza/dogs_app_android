package com.isczaragoza.dogsapp.domain.resultHandler

import com.isczaragoza.dogsapp.domain.enums.BaseError


sealed interface Result<out T> {
    data class Success<T>(val data: T) : Result<T>
    data class Error(val baseError: BaseError) : Result<Nothing>
}