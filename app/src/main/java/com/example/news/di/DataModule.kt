package com.example.news.di

import com.example.news.data.NewsRepositoryImpl
import com.example.news.data.database.AppDatabase
import com.example.news.data.mappers.NewsMapper
import com.example.news.data.network.RetrofitRepository
import com.example.news.domain.repository.NewsRepository
import org.koin.dsl.module

val dataModule = module {

    single<NewsRepository> {
        NewsRepositoryImpl(RetrofitRepository(),
            AppDatabase.getInstance(applicationContext = get()),
            NewsMapper()
        )
    }

    single{
        RetrofitRepository()
    }

    single {
        AppDatabase.getInstance(applicationContext = get())
    }

    factory {
        NewsMapper()
    }



    
}