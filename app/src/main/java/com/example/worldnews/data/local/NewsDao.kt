package com.example.worldnews.data.local

import androidx.room.*
import com.example.worldnews.model.news.Article
import com.example.worldnews.model.news.New


@Dao
interface NewsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveaNews(article: Article)

    @Query("SELECT * FROM news")
    fun getNews():List<Article>

    @Query("SELECT FROM user WHERE id =:id")
    fun deleteNews(id:Long)

    @Query("DELETE FROM news")
    fun clearNews()


    @Delete
    fun deleteNews2(article: Article)

}

