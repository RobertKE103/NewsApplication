package com.example.news.domain.repository

import androidx.lifecycle.LiveData
import com.example.news.domain.models.NewsResponse
import retrofit2.Response

interface NewsRepository {

    suspend fun getHeadlines(): Response<NewsResponse>

    suspend fun getEverything(): Response<NewsResponse>

    suspend fun addFavorite(newsResponse: NewsResponse)

    suspend fun deleteFavorite(id: Int)

    suspend fun getFavorite(): LiveData<NewsResponse>

}