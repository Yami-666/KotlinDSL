package com.example.core.result

import com.example.core.interfaces.mapper.IMapper
import com.example.core.interfaces.mapper.convert
import com.example.core.utility.FlowResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.mapNotNull

inline fun <reified T : Any?> T?.toSuccessResponse(defaultResult: Response<T> = Response.Error): Response<T> {
    return this?.let {
        successResult(it)
    } ?: defaultResult
}

inline fun <reified T : Any?> Flow<T?>.toFlowSuccessResponse(defaultResult: Response<T> = Response.Error): Flow<Response<T>> {
    return this.map { data ->
        data?.let {
            successResult(it)
        } ?: defaultResult
    }
}

inline fun <reified T : IMapper.To<O>, reified O : Any> FlowResult<T>.mapFlowTo(): Flow<Response<O>> {
    return this.mapNotNull {
        if (it is Response.Success) {
            it.data.convert()
                .toSuccessResponse()
        } else Response.Error
    }
}

inline fun <reified T : IMapper.To<O>, reified O : Any> Response<T>.convertTo(): Response<O> {
    return if (this is Response.Success) {
        this.data.convert().toSuccessResponse()
    } else Response.Error
}

inline fun <reified T : Any> Any.successResult(data: T): Response<T> =
    Response.Success(data)