package com.example.core.interfaces.domain

import kotlinx.coroutines.flow.Flow

interface IUseCase {
    interface In<T> {
        suspend fun invoke(param: T)
    }

    interface Out<T> {
        suspend operator fun invoke(): T
    }

    interface InOut<T, V> {
        suspend operator fun invoke(param: T): V
    }

    interface FlowOut<T> {
        operator fun invoke(): Flow<T>
    }

    interface FlowInOut<T, V> {
        operator fun invoke(param: T): Flow<V>
    }
}