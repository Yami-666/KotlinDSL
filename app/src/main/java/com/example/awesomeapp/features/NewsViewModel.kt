package com.example.awesomeapp.features

import androidx.lifecycle.viewModelScope
import com.example.core.base.BaseViewModel
import com.example.core.extensions.toStateFlow
import com.example.core.extensions.unsafeLazy
import com.example.data.repository.news.data.ArticleData
import com.example.domain.news.IGetNewsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(
    private val getNewsUseCase: IGetNewsUseCase
) : BaseViewModel() {

    val news: StateFlow<List<ArticleData>> by unsafeLazy {
        getNewsUseCase()
            .onStart {
                showLoading()
                // For testing loading bar
                delay(1000L)
            }
            .mapNotNull { it.data?.articles }
            .onCompletion { hideLoading() }
            .flowOn(Dispatchers.IO)
            .toStateFlow(viewModelScope) { emptyList() }
    }
}