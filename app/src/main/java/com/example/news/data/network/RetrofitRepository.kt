package com.example.news.data.network

import com.example.news.domain.models.NewsResponse
import retrofit2.Response

class RetrofitRepository {

    suspend fun getEverything(key: String): Response<NewsResponse> {
        return RetrofitInstance.api.getEverything(
            query = key
        )
    }

    suspend fun getHeadlines(category: String): Response<NewsResponse> {
        return RetrofitInstance.api.getHeadlines(
            category = category
        )
    }



}