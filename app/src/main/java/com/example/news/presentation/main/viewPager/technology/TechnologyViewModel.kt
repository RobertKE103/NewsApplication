package com.example.news.presentation.main.viewPager.technology

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.news.domain.models.NewsResponse
import com.example.news.domain.usecase.GetHeadlinesUseCase
import com.example.news.presentation.main.viewPager.sports.SportFragment
import kotlinx.coroutines.launch
import retrofit2.Response

class TechnologyViewModel(
    private val getHeadlinesUseCase: GetHeadlinesUseCase
) : ViewModel() {
    private val _listNews = MutableLiveData<Response<NewsResponse>>()
    val listNews: LiveData<Response<NewsResponse>> get() = _listNews


    fun getNews(){
        viewModelScope.launch {
            _listNews.value = getHeadlinesUseCase.invoke(TechnologyFragment.category)
        }
    }
}