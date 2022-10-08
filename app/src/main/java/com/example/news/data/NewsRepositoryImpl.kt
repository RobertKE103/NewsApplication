package com.example.news.data

import androidx.lifecycle.LiveData
import com.example.news.domain.repository.NewsRepository
import com.example.news.domain.models.NewsResponse
import retrofit2.Response

class NewsRepositoryImpl: NewsRepository {


    override suspend fun getHeadlines(): Response<NewsResponse> {
        TODO("Not yet implemented")
    }

    override suspend fun getEverything(): Response<NewsResponse> {
        TODO("Not yet implemented")
    }

    override suspend fun addFavorite(newsResponse: NewsResponse) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteFavorite(id: Int) {
        TODO("Not yet implemented")
    }

    override suspend fun getFavorite(): LiveData<NewsResponse> {
        TODO("Not yet implemented")
    }


}