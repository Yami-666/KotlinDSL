package com.example.core.result

sealed class Response<out T> {
    open val data: T? = null

    class Success<T>(override val data: T) : Response<T>()
    object Empty : Response<Nothing>()
    object Loading : Response<Nothing>()
    object Error : Response<Nothing>()
}