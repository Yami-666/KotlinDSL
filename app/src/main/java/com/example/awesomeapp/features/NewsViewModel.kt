package com.example.awesomeapp.features

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.core.base.BaseViewModel
import com.example.core.extensions.unsafeLazy
import com.example.data.repository.news.data.ArticleData
import com.example.domain.news.IGetNewsUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import javax.inject.Inject
import javax.inject.Provider

class NewsViewModel(
    private val getNewsUseCase: IGetNewsUseCase
) : BaseViewModel() {

    private val _isLoading = MutableStateFlow(false)
    val isLoading = _isLoading.asStateFlow()

    val news: StateFlow<List<ArticleData>> by unsafeLazy {
        getNewsUseCase()
            .onStart {
                showLoading()
                delay(1000L)
            }
            .mapNotNull { it.data?.articles }
            .onCompletion { hideLoading() }
            .toStateFlow(viewModelScope) { emptyList() }
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

inline fun <reified T> Flow<T>.toStateFlow(
    scope: CoroutineScope,
    started: SharingStarted = SharingStarted.Lazily,
    initialValue: () -> T,
): StateFlow<T> {
    return this.stateIn(
        scope = scope,
        started = started,
        initialValue = initialValue.invoke()
    )
}