package com.example.core.extensions

import com.example.core.BuildConfig
import timber.log.Timber

const val DEFAULT_TAG = "------> "

inline fun Any.logg(lambda: () -> String?) {
    Timber.d("$DEFAULT_TAG[${this::class.java.simpleName}]: ${lambda().orEmpty()}")
}

fun Any.logg(message: String?, tag: String = DEFAULT_TAG) {
    Timber.d("$tag [${this::class.java.simpleName}]: ${message.orEmpty()}")
}

fun Any.loggE(exception: Throwable? = null, message: String? = null) {
    if(this is Throwable) {
        Timber.e(this, message)
    } else {
        Timber.e(exception, message)
    }
}

fun Any.loggE(lambda: () -> String) {
    Timber.e(this.toString(), lambda())
}

fun <T, R> T?.doIfNull(input: () -> R): Any? {
    return this ?: input()
}

inline fun <reified T> T?.orIfNull(input: () -> T): T {
    return this ?: input()
}

fun <T> T.applyIf(prediction: Boolean, input: (T) -> Unit): T {
    if (prediction) input.invoke(this)
    return this
}

inline fun <reified I : Any, reified R : Any> Any.flatMapForType(block: (I) -> R): Any {
    return if (this is I) block(this)
    else this
}

inline fun <reified T, reified R> R.unsafeLazy(noinline init: () -> T): Lazy<T> =
    lazy(LazyThreadSafetyMode.NONE, init)

inline fun runIfDebug(function: () -> Unit) {
    if (BuildConfig.DEBUG) {
        function()
    }
}

inline fun runIfRelease(function: () -> Unit) {
    if (!BuildConfig.DEBUG) {
        function()
    }
}

fun <T: Any>T?.logIfNull(message: String): T? {
    if (this == null) {
        Timber.e(message)
    }
    return this
}
