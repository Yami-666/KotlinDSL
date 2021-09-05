package com.example.awesomeapp.features

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.core.base.BaseViewModel
import com.example.core.extensions.unsafeLazy
import com.example.data.repository.news.data.NewsData
import com.example.domain.news.IGetNewsUseCase
import kotlinx.coroutines.flow.*
import javax.inject.Inject
import javax.inject.Provider

class NewsViewModel(
    private val getNewsUseCase: IGetNewsUseCase
) : BaseViewModel() {

    private val _isLoading = MutableStateFlow(false)
    val isLoading = _isLoading.asStateFlow()

    val news: SharedFlow<NewsData> by unsafeLazy {
        getNewsUseCase()
            .onStart { showLoading() }
            .mapNotNull { it.data }
            .onCompletion { hideLoading() }
            .shareIn(viewModelScope, SharingStarted.Lazily, replay = 1)
    }

    private fun showLoading() {
        _isLoading.value = true
    }

    private fun hideLoading() {
        _isLoading.value = false
    }

    class Factory @Inject constructor(
        private val getNewsUseCase: Provider<IGetNewsUseCase>
    ) : ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            require(modelClass == NewsViewModel::class.java)
            return NewsViewModel(getNewsUseCase.get()) as T
        }
    }
}

