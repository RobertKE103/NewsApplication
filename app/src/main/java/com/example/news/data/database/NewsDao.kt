package com.example.news.data.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.news.data.entity.ArticleDbModel
import com.example.news.domain.models.Article
import com.example.news.domain.models.NewsResponse


@Dao
interface NewsDao {

    @Query("SELECT * FROM favoriteNews")
    fun getFavoriteNews(): LiveData<List<ArticleDbModel>>

    @Query("SELECT * FROM favoriteNews WHERE id=:favoriteNewsId LIMIT 1")
    suspend fun getItemFavoriteNews(favoriteNewsId: Int): ArticleDbModel

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addFavorite(articleDbModel: ArticleDbModel)

    @Query("DELETE FROM favoriteNews WHERE id=:favoriteNewsId")
    suspend fun deleteFavorite(favoriteNewsId: Int)

}