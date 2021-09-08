package com.example.core.utility

import com.example.core.result.Response
import kotlinx.coroutines.flow.Flow

typealias FlowResult<T> = Flow<Response<T>>
typealias FlowResultList<T> = Flow<Response<List<T>>>

typealias ResultList<T> = Response<List<T>>
typealias ResultMutableList<T> = Response<MutableList<T>>