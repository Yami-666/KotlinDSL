package com.example.news_list.data.remote

import com.example.core.extensions.logg
import com.example.core.result.Response
import com.example.core.result.toSuccessResponse
import com.example.news_list.data.remote.models.NewsModel
import com.example.news_list.data.remote.servies.NewsService
import ru.nightgoat.kextensions.doOnIO
import javax.inject.Inject

class NewsRemoteDataSource @Inject constructor(
    private val newsApi: NewsService
) : INewsRemoteDataSource {

    override suspend fun getTopHeadlines(): Response<NewsModel> = doOnIO {
        val response = newsApi.getTopHeadlines("ru")
        logg { response.toString() }
        response.toSuccessResponse()
    }
}