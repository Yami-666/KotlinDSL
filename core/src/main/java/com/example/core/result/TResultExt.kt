package com.example.core.result

import com.example.core.interfaces.mapper.IMapper
import com.example.core.interfaces.mapper.convert
import com.example.core.utility.FlowResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.mapNotNull

inline fun <reified T : Any?> T?.toSuccessResult(defaultResult: TResult<T> = TResult.Error): TResult<T> {
    return this?.let {
        successResult(it)
    } ?: defaultResult
}

inline fun <reified T : Any?> Flow<T?>.toFlowSuccessResult(defaultResult: TResult<T> = TResult.Error): Flow<TResult<T>> {
    return this.map { data ->
        data?.let {
            successResult(it)
        } ?: defaultResult
    }
}

inline fun <reified T : IMapper.To<O>, reified O : Any> FlowResult<T>.mapFlowTo(): Flow<TResult<O>> {
    return this.mapNotNull {
        if (it is TResult.Success) {
            it.data.convert()
                .toSuccessResult()
        } else TResult.Error
    }
}

inline fun <reified T : IMapper.To<O>, reified O : Any> TResult<T>.convertTo(): TResult<O> {
    return if (this is TResult.Success) {
        this.data.convert().toSuccessResult()
    } else TResult.Error
}

inline fun <reified T : Any> Any.successResult(data: T): TResult<T> =
    TResult.Success(data)