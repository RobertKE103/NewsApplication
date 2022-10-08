package com.example.news.data.network

import com.example.news.domain.models.NewsResponse
import com.example.news.utils.Const.Companion.API_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsService {

    @GET("v2/everything")
    suspend fun getEverything(
        @Query("apiKey") apiKey: String = API_KEY,
        @Query("language") page: String = "ru",
        @Query("q") query: String,
    ): Response<NewsResponse>

    @GET("v2/top-headlines")
    suspend fun getHeadlines(
        @Query("country") country: String = "ru",
        @Query("page") page: Int = 20,
        @Query("apiKey") apiKey: String = API_KEY,
        @Query("category") category: String
    ): Response<NewsResponse>

}