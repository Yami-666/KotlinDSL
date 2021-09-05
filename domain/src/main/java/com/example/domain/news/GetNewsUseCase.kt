package com.example.domain.news

import com.example.core.interfaces.domain.IUseCase
import com.example.core.result.TResult
import com.example.core.utility.FlowResult
import com.example.data.repository.news.INewsRepository
import com.example.data.repository.news.data.NewsData
import javax.inject.Inject

class GetNewsUseCase @Inject constructor(
    private val newsRepository: INewsRepository
): IGetNewsUseCase {
    override fun invoke(): FlowResult<NewsData> {
        return newsRepository.getNews()
    }
}

interface IGetNewsUseCase : IUseCase.FlowOut<TResult<NewsData>>