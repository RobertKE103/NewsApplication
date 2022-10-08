package com.example.news.domain.usecase

import com.example.news.domain.repository.NewsRepository

class DeleteFavoriteUseCase(private val repository: NewsRepository) {

    suspend operator fun invoke(id: Int){
        return repository.deleteFavorite(id)
    }


}