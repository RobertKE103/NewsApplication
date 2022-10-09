package com.example.news.domain.usecase

import androidx.lifecycle.LiveData
import com.example.news.domain.models.Article
import com.example.news.domain.repository.NewsRepository

class GetFavoriteListUseCase(private val repository: NewsRepository) {
    operator fun invoke(): LiveData<List<Article>>{
        return repository.getFavoriteList()
    }
}