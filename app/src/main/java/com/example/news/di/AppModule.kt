package com.example.news.di

import com.example.news.presentation.details.DetailsFragmentViewModel
import com.example.news.presentation.favorite.FavoriteFragmentViewModel
import com.example.news.presentation.main.MainFragmentViewModel
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


}