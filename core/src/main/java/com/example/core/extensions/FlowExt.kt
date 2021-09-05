package com.example.core.extensions

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn

inline fun <reified T> Flow<T>.toStateFlow(
    scope: CoroutineScope,
    started: SharingStarted = SharingStarted.WhileSubscribed(),
    initialState: () -> T
): StateFlow<T> {
    return this.stateIn(
        scope = scope,
        started = started,
        initialValue = initialState.invoke()
    )
}