package com.example.data.repository.news

import com.example.core.interfaces.data.IBaseRemoteRepository
import com.example.core.result.mapFlowTo
import com.example.core.utility.FlowResult
import com.example.data.repository.news.data.NewsData
import javax.inject.Inject

internal class NewsRepository @Inject constructor(
    override val remoteDataSource: INewsRemoteDataSource
) : INewsRepository {
    override fun getNews(): FlowResult<NewsData> {
        return remoteDataSource.getNews().mapFlowTo()
    }

    override fun getNews(id: String): FlowResult<NewsData> {
        return remoteDataSource.getNews().mapFlowTo()
    }
}

interface INewsRepository : IBaseRemoteRepository<INewsRemoteDataSource> {
    fun getNews(): FlowResult<NewsData>
    fun getNews(id: String): FlowResult<NewsData>
}
