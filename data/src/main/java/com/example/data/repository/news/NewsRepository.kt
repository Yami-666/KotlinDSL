package com.example.data.repository.news

import com.example.core.interfaces.data.IBaseRemoteRepository
import com.example.core.result.convertTo
import com.example.core.result.mapFlowTo
import com.example.core.utility.FlowResult
import com.example.data.repository.news.data.NewsData
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class NewsRepository @Inject constructor(
    override val remoteDataSource: INewsRemoteDataSource
) : INewsRepository {
    override fun getNews(): FlowResult<NewsData> {
        return flow {
            emit(remoteDataSource.getTopHeadlines().convertTo())
        }
    }

    override fun getNews(id: String): FlowResult<NewsData> {
        return remoteDataSource.getNews(id).mapFlowTo()
    }
}

interface INewsRepository : IBaseRemoteRepository<INewsRemoteDataSource> {
    fun getNews(): FlowResult<NewsData>
    fun getNews(id: String): FlowResult<NewsData>
}
