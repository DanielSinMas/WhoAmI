package com.danielgimenez.domain.model

sealed class Response<out T: Any> {

    data class Success<out T: List<UserUiModel>>(val data: T): Response<T>()
    data class Error(val error: String): Response<Nothing>()
    object Loading: Response<Nothing>()
}