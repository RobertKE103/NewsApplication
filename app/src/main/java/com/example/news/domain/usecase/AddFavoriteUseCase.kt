package com.example.news.domain.usecase

import com.example.news.domain.models.Article
import com.example.news.domain.repository.NewsRepository
import com.example.news.domain.models.NewsResponse

class AddFavoriteUseCase(private val repository: NewsRepository) {
    suspend operator fun invoke(article: Article){
        return repository.addFavorite(article)
    }
}