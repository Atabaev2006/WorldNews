package com.example.worldnews.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.worldnews.model.news.Article
import com.example.worldnews.model.news.New

@Database(entities = [Article::class], version = 1)

abstract class NewsDatabase :RoomDatabase() {
    abstract fun getNewsDao():NewsDao



    companion object{
        private var DB_INSTANCE:NewsDatabase? = null


        fun getAppInstance(context: Context): NewsDatabase {
            if (DB_INSTANCE == null){
                DB_INSTANCE= Room.databaseBuilder(
                    context.applicationContext,
                    NewsDatabase::class.java,
                    "news"
                )
                    .allowMainThreadQueries()
                    .build()
            }
         return DB_INSTANCE!!
        }
    }
}