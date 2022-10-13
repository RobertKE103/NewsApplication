package com.example.news.di

import com.example.news.presentation.details.DetailsFragmentViewModel
import com.example.news.presentation.favorite.FavoriteFragmentViewModel
import com.example.news.presentation.main.MainFragmentViewModel
import com.example.news.presentation.main.viewPager.general.GeneralViewModel
import com.example.news.presentation.main.viewPager.sports.SportViewModel
import com.example.news.presentation.main.viewPager.technology.TechnologyViewModel
import com.example.news.presentation.search.SearchFragmentViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    viewModel{
        MainFragmentViewModel()
    }

    viewModel{
        DetailsFragmentViewModel()
    }

    viewModel{
        FavoriteFragmentViewModel()
    }

    viewModel{
        SearchFragmentViewModel()
    }

    viewModel{
        GeneralViewModel(getHeadlinesUseCase = get())
    }

    viewModel{
        TechnologyViewModel(getHeadlinesUseCase = get())
    }

    viewModel{
        SportViewModel(getHeadlinesUseCase = get())
    }


}