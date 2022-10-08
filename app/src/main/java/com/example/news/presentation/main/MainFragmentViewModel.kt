package com.example.news.presentation.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.news.data.NewsRepositoryImpl
import com.example.news.domain.models.NewsResponse
import com.example.news.domain.usecase.GetEverythingUseCase
import kotlinx.coroutines.launch
import retrofit2.Response

class MainFragmentViewModel: ViewModel() {

    private var ld = MutableLiveData<Response<NewsResponse>>()

    fun pe(){
        viewModelScope.launch{
            ld.value = GetEverythingUseCase(repository = NewsRepositoryImpl())
                .invoke()
        }

    }

}