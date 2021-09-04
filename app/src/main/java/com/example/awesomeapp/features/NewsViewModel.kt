package com.example.awesomeapp.features

import com.example.core.base.BaseViewModel
import com.example.core.extensions.unsafeLazy
import com.example.domain.news.IGetNewsUseCase
import kotlinx.coroutines.flow.*
import javax.inject.Inject

class NewsViewModel @Inject constructor(
    private val getNewsUseCase: IGetNewsUseCase
) : BaseViewModel() {

    private val _isError = MutableStateFlow("Internal error")
    val isError = _isError.asStateFlow()

    private val _isLoading = MutableStateFlow(false)
    val isLoading = _isLoading.asStateFlow()

    val news by unsafeLazy {
        getNewsUseCase()
            .onStart { showLoading() }
            .mapNotNull { it.data }
            .onCompletion { hideLoading() }
    }

    private fun showLoading() {
        _isLoading.value = true
    }

    private fun hideLoading() {
        _isLoading.value = false
    }
}

