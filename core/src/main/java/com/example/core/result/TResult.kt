package com.example.core.result

sealed class TResult<out T> {
    open val data: T? = null

    class Success<T>(override val data: T) : TResult<T>()
    object Empty : TResult<Nothing>()
    object Loading : TResult<Nothing>()
    object Error : TResult<Nothing>()
}