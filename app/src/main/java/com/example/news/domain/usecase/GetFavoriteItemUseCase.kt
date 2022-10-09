package com.example.news.domain.usecase

import com.example.news.domain.models.Article
import com.example.news.domain.repository.NewsRepository

class GetFavoriteItemUseCase(private val repository: NewsRepository) {
    suspend operator fun invoke(id: Int): Article {
        return repository.getFavoriteItem(id)
    }
}