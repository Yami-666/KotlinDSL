package com.example.news_list.presenation.news

import androidx.lifecycle.viewModelScope
import com.example.core.base.BaseViewModel
import com.example.core.extensions.toStateFlow
import com.example.core.extensions.unsafeLazy
import com.example.news_list.domain.IGetNewsUseCase
import com.example.news_list.domain.data.ArticleData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import javax.inject.Inject

class NewsViewModel @Inject constructor(
    private val getNewsUseCase: IGetNewsUseCase
) : BaseViewModel() {

    val news: StateFlow<List<ArticleData>> by unsafeLazy {
        getNewsUseCase()
            .onStart { showLoading() }
            .mapNotNull { it.data?.articles }
            .onCompletion { hideLoading() }
            .flowOn(Dispatchers.IO)
            .toStateFlow(viewModelScope) { emptyList() }
    }
}