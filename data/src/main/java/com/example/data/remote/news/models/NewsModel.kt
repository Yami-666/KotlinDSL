package com.example.data.remote.news.models

import com.example.core.extensions.mapListToOrEmpty
import com.example.core.interfaces.mapper.IMapper
import com.example.data.repository.news.data.NewsData
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import ru.nightgoat.kextensions.orZero

@JsonClass(generateAdapter = true)
data class NewsModel(
    @Json(name = "status")
    val status: String?,
    @Json(name = "totalResults")
    val totalArticles: Int?,
    @Json(name = "articles")
    val articles: List<ArticleModel>?
) : IMapper.To<NewsData>{
    override fun convertTo(): NewsData {
        return NewsData(
            status = status.orEmpty(),
            totalArticles = totalArticles.orZero(),
            articles = articles.mapListToOrEmpty(),
        )
    }
}
