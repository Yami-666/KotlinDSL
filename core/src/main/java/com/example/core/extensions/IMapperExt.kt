package com.example.core.extensions

import com.example.core.interfaces.mapper.IMapper
import com.example.core.interfaces.mapper.convert

inline fun <reified T : IMapper.To<O>, reified O: Any> List<T>?.mapListToOrEmpty(): List<O> {
    return this?.mapNotNull {
        it.convert()
    } ?: emptyList()
}