@file:Suppress("UNCHECKED_CAST", "UNUSED")

package com.example.core.interfaces.mapper

import kotlin.reflect.KClass

interface IMapper {

    interface To<out O> : IConverter {
        fun convertTo(): O?

        override fun <I : Any, O> convertAs(clazz: KClass<I>): O? {
            return convertTo() as? O
        }
    }

    interface ToWithParams<P, out O> : IConverter {
        fun convertTo(params: P): O?

        override fun <I : Any, O> convertAs(clazz: KClass<I>): O? = null

        fun <I, O> convertAs(clazz: I, params: P): O? = convertTo(params) as? O
    }
}