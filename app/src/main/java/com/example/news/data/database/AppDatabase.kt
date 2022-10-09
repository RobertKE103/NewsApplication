package com.example.news.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.news.data.entity.ArticleDbModel


@Database(entities = [ArticleDbModel::class], version = 1, exportSchema = false)
abstract class AppDatabase: RoomDatabase() {

    abstract fun newsDao(): NewsDao

    companion object {

        private var INSTANCE: AppDatabase? = null
        private val LOCK = Any()

        fun getInstance(applicationContext: Context): AppDatabase{

            INSTANCE?.let {
                return it
            }
            synchronized(LOCK) {
                INSTANCE?.let {
                    return it
                }
                val db = Room.databaseBuilder(
                    applicationContext,
                    AppDatabase::class.java,
                    "favoriteNews.db"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = db
                return db
            }
        }



    }

}