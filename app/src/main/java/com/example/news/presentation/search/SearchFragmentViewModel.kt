package com.example.news.presentation.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.news.domain.models.Article
import com.example.news.domain.models.NewsResponse
import com.example.news.domain.usecase.AddFavoriteUseCase
import com.example.news.domain.usecase.GetEverythingUseCase
import kotlinx.coroutines.launch
import retrofit2.Response

class SearchFragmentViewModel(
    private val getEverythingUseCase: GetEverythingUseCase,
    private val addFavoriteUseCase: AddFavoriteUseCase,
) : ViewModel() {


    private var _listNews = MutableLiveData<Response<NewsResponse>>()
    val listNews: LiveData<Response<NewsResponse>> get() = _listNews


    fun getNews(key: String){
        viewModelScope.launch {
            _listNews.value = getEverythingUseCase.invoke(key)
        }
    }


}