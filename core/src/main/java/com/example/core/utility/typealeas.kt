package com.example.core.utility

import com.example.core.result.TResult
import kotlinx.coroutines.flow.Flow

typealias FlowResult<T> = Flow<TResult<T>>
typealias FlowResultList<T> = Flow<TResult<List<T>>>

typealias ResultList<T> = TResult<List<T>>
typealias ResultMutableList<T> = TResult<MutableList<T>>