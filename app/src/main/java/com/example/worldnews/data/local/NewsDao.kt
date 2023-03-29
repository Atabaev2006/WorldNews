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

    @Query("DELETE FROM news WHERE id =:id")
    fun deleteNews(id:Int)

    @Query("DELETE FROM news")
    fun clearNews()


    @Delete
    fun deleteNews2(article: Article)

}

