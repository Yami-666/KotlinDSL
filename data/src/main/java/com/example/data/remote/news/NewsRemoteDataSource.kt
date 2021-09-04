package com.example.data.remote.news

import com.example.core.result.toFlowSuccessResult
import com.example.core.utility.FlowResult
import com.example.data.remote.news.models.NewsModel
import com.example.data.remote.news.servies.NewsService
import com.example.data.repository.news.INewsRemoteDataSource
import javax.inject.Inject

class NewsRemoteDataSource @Inject constructor(
    private val newsApi: NewsService
) : INewsRemoteDataSource {

    override fun getNews(): FlowResult<NewsModel> {
        return newsApi.getNews().toFlowSuccessResult()
    }

    override fun getNews(id: String): FlowResult<NewsModel> {
        return newsApi.getNews(id).toFlowSuccessResult()
    }
}