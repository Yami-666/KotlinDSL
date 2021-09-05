package com.example.data.remote.news.servies

import com.example.data.BuildConfig
import com.example.data.remote.news.models.NewsModel
import kotlinx.coroutines.flow.Flow
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface NewsService {
    @GET("v2/top-headlines")
    suspend fun getTopHeadlines(@Query("country") country: String): NewsModel

    @GET("news")
    fun getNews(): Flow<NewsModel>

    @GET("news/{id}")
    fun getNews(@Path("id") id: String): Flow<NewsModel>
}

fun NewsService(apiKey: String): NewsService {
    val okHttpClient = OkHttpClient.Builder()
        .addInterceptor { chain ->
            val authorizedRequest = chain.request()
                .newBuilder()
                .addHeader(HEADER_API,apiKey)
                .build()
            chain.proceed(authorizedRequest)
        }
        .build()

    val retrofit = Retrofit.Builder()
        .baseUrl(BuildConfig.BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create())
        .client(okHttpClient)
        .build()

    return retrofit.create()
}

private const val HEADER_API = "X-Api-Key"

