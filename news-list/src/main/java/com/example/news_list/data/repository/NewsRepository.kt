package com.example.news_list.data.repository

import com.example.core.interfaces.data.IBaseRemoteRepository
import com.example.core.result.convertTo
import com.example.core.utility.FlowResult
import com.example.news_list.data.remote.INewsRemoteDataSource
import com.example.news_list.domain.data.NewsData
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
internal class NewsRepository @Inject constructor(
    override val remoteDataSource: INewsRemoteDataSource
) : INewsRepository {
    override fun getNews(): FlowResult<NewsData> {
        return flow {
            emit(remoteDataSource.getTopHeadlines().convertTo())
        }
    }
}

interface INewsRepository : IBaseRemoteRepository<INewsRemoteDataSource> {
    fun getNews(): FlowResult<NewsData>
}
