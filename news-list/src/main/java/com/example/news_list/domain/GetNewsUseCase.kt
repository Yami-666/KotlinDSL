package com.example.news_list.domain

import com.example.core.interfaces.domain.IUseCase
import com.example.core.result.Response
import com.example.core.utility.FlowResult
import com.example.news_list.data.repository.INewsRepository
import com.example.news_list.domain.data.NewsData
import javax.inject.Inject

class GetNewsUseCase @Inject constructor(
    private val newsRepository: INewsRepository
): IGetNewsUseCase {
    override fun invoke(): FlowResult<NewsData> {
        return newsRepository.getNews()
    }
}

interface IGetNewsUseCase : IUseCase.FlowOut<Response<NewsData>>