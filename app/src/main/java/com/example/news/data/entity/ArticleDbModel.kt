package com.example.news.data.entity

data class ArticleDbModel(
    val author: String,
    val content: String,
    val description: String,
    val publishedAt: String,
    val sourceEntity: SourceDbModel,
    val title: String,
    val url: String,
    val urlToImage: String
)