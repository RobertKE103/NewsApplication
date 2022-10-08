package com.example.news.di

import com.example.news.data.NewsRepositoryImpl
import com.example.news.domain.repository.NewsRepository
import org.koin.dsl.module

val dataModule = module {

    single<NewsRepository> {
        NewsRepositoryImpl()
    }
    
}