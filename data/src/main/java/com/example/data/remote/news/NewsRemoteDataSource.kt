package com.example.data.remote.news

import com.example.core.extensions.logg
import com.example.core.result.TResult
import com.example.core.result.toFlowSuccessResult
import com.example.core.result.toSuccessResult
import com.example.core.utility.FlowResult
import com.example.data.remote.news.models.NewsModel
import com.example.data.remote.news.servies.NewsService
import com.example.data.repository.news.INewsRemoteDataSource
import ru.nightgoat.kextensions.doOnIO
import javax.inject.Inject

class NewsRemoteDataSource @Inject constructor(
    private val newsApi: NewsService
) : INewsRemoteDataSource {

    override suspend fun getTopHeadlines(): TResult<NewsModel> = doOnIO {
        val response = newsApi.getTopHeadlines("ru")
        logg { response.toString() }
        response.toSuccessResult()
    }

    override fun getNews(id: String): FlowResult<NewsModel> {
        return newsApi.getNews(id).toFlowSuccessResult()
    }
}