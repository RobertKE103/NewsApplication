package com.example.news.domain.usecase

import com.example.news.domain.repository.NewsRepository
import com.example.news.domain.models.NewsResponse
import retrofit2.Response

class GetEverythingUseCase(private val repository: NewsRepository){

    suspend operator fun invoke(): Response<NewsResponse> {
        return repository.getEverything()
    }

}
