package com.example.news_list.domain.data

data class NewsData(
    val status: String,
    val totalArticles: Int,
    val articles: List<ArticleData>
)
