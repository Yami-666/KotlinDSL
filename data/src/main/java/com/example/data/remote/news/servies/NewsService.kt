package com.example.data.remote.news.servies

import com.example.data.remote.news.models.NewsModel
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET
import retrofit2.http.Path

interface NewsService {
    @GET("news")
    fun getNews(): Flow<NewsModel>

    @GET("news/{id}")
    fun getNews(@Path("id") id: String): Flow<NewsModel>

    fun NewsService(apiKey: String): NewsService {
        TODO(apiKey)
    }
}

