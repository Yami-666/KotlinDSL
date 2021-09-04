package com.example.data.repository.news.data

data class NewsData(
    val status: String,
    val totalArticles: Int,
    val articles: List<ArticleData>
)
