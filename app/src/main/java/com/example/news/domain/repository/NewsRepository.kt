package com.example.news.domain.repository

import androidx.lifecycle.LiveData
import com.example.news.domain.models.Article
import com.example.news.domain.models.NewsResponse
import retrofit2.Response

interface NewsRepository {

    suspend fun getHeadlines(category: String): Response<NewsResponse>

    suspend fun getEverything(key: String): Response<NewsResponse>

    suspend fun addFavorite(article: Article)

    suspend fun deleteFavorite(id: Int)

    suspend fun getFavoriteItem(id: Int): Article

    fun getFavoriteList(): LiveData<List<Article>>



}