package com.example.news.data.entity

import androidx.room.ColumnInfo

data class SourceDbModel(
    @ColumnInfo(name = "source_id")
    val id: String,
    val name: String
)