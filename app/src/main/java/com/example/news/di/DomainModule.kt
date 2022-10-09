package com.example.news.di

import com.example.news.domain.usecase.*
import org.koin.dsl.module


val domainModule = module {

    factory {
        GetFavoriteListUseCase(repository = get())
    }

    factory {
        GetFavoriteItemUseCase(repository = get())
    }

    factory {
        AddFavoriteUseCase(repository = get())
    }

    factory {
        DeleteFavoriteUseCase(repository = get())
    }

    factory {
        GetEverythingUseCase(repository = get())
    }

    factory {
        GetHeadlinesUseCase(repository = get())
    }



}