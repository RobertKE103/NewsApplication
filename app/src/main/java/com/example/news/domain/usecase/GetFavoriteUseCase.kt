package com.example.news.domain.usecase

import androidx.lifecycle.LiveData
import com.example.news.domain.repository.NewsRepository
import com.example.news.domain.models.NewsResponse

class GetFavoriteUseCase(private val repository: NewsRepository) {

    suspend operator fun invoke(): LiveData<NewsResponse>{
        return repository.getFavorite()
    }

}