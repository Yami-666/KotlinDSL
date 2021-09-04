package com.example.data.repository.news.data

data class ArticleData(
    val source: SourceData?,
    val author: String,
    val title: String,
    val description: String,
    val url: String,
    val imageUrl: String,
    val publishedAt: String,
    val content: String,
)