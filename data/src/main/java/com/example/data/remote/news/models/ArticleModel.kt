package com.example.data.remote.news.models

import com.example.core.interfaces.mapper.IMapper
import com.example.data.repository.news.data.ArticleData
import com.squareup.moshi.Json

data class ArticleModel(
    @Json(name = "source")
    val source: SourceModel?,
    @Json(name = "author")
    val author: String?,
    @Json(name = "title")
    val title: String?,
    @Json(name = "description")
    val description: String?,
    @Json(name = "url")
    val url: String?,
    @Json(name = "urlToImage")
    val imageUrl: String?,
    @Json(name = "publishedAt")
    val publishedAt: String?,
    @Json(name = "content")
    val content: String?,
) : IMapper.To<ArticleData> {
    override fun convertTo(): ArticleData {
        return ArticleData(
            source = source?.convertTo(),
            author = author.orEmpty(),
            title = title.orEmpty(),
            description = description.orEmpty(),
            url = url.orEmpty(),
            imageUrl = imageUrl.orEmpty(),
            publishedAt = publishedAt.orEmpty(),
            content = content.orEmpty(),
        )
    }
}








