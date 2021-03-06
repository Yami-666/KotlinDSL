package com.example.data.repository.news

import com.example.core.interfaces.data.IRemoteDataSource
import com.example.core.result.TResult
import com.example.core.utility.FlowResult
import com.example.data.remote.news.models.NewsModel

interface INewsRemoteDataSource: IRemoteDataSource {
    suspend fun getTopHeadlines(): TResult<NewsModel>
    fun getNews(id: String): FlowResult<NewsModel>
}