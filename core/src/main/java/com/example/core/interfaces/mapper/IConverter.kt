package com.example.core.interfaces.mapper

import kotlin.reflect.KClass

interface IConverter {
    fun <I : Any, O> convertAs(clazz: KClass<I>): O?
}

inline fun <reified To : Any> IMapper.To<To>.convert(): To? {
    return convertAs(To::class)
}