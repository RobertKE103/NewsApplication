package com.example.news.data.entity

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "favoriteNews")
data class ArticleDbModel(
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    val author: String,
    val content: String,
    val description: String,
    val publishedAt: String,
    @Embedded(prefix = "prefix_")
    val sourceEntity: SourceDbModel,
    val title: String,
    val url: String,
    val urlToImage: String
)