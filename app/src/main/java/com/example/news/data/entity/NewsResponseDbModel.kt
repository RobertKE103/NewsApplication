package com.example.news.data.entity

data class NewsResponseDbModel(
    val articleEntities: List<ArticleDbModel>,
    val status: String,
    val totalResults: Int
)