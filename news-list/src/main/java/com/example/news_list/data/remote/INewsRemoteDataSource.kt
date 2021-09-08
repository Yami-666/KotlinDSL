package com.example.news_list.data.remote

import com.example.core.interfaces.data.IRemoteDataSource
import com.example.core.result.Response
import com.example.news_list.data.remote.models.NewsModel

interface INewsRemoteDataSource: IRemoteDataSource {
    suspend fun getTopHeadlines(): Response<NewsModel>
}