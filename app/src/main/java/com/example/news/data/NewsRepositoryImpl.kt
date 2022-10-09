package com.example.news.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import com.example.news.data.database.AppDatabase
import com.example.news.data.mappers.NewsMapper
import com.example.news.data.network.RetrofitRepository
import com.example.news.domain.models.Article
import com.example.news.domain.models.NewsResponse
import com.example.news.domain.repository.NewsRepository
import retrofit2.Response

class NewsRepositoryImpl(
    private val retrofit: RetrofitRepository,
    private val database: AppDatabase,
    private val mapper: NewsMapper
) : NewsRepository {


    override suspend fun getHeadlines(category: String): Response<NewsResponse> {
        return retrofit.getHeadlines(category)
    }

    override suspend fun getEverything(key: String): Response<NewsResponse> {
        return retrofit.getEverything(key)
    }

    override suspend fun addFavorite(article: Article) {
        database.newsDao().addFavorite(mapper.mapArticleEntityToDbModel(article))
    }

    override suspend fun deleteFavorite(id: Int) {
        database.newsDao().deleteFavorite(id)
    }

    override suspend fun getFavoriteItem(id: Int): Article {
        return mapper.mapArticleDbModelToEntity(database.newsDao().getItemFavoriteNews(id))
    }

    override fun getFavoriteList(): LiveData<List<Article>> =
        MediatorLiveData<List<Article>>().apply {
            addSource(database.newsDao().getFavoriteNews()) {
                value = mapper.mapListDbModelToEntity(it)
            }
        }
}