package com.example.worldnews.data.local

import android.app.Application
import com.example.worldnews.model.news.Article
import com.example.worldnews.ui.fragment.SaveFragment

class NewsRepository {
    lateinit var newsDao: NewsDao

    constructor(application: Application){
        val db=NewsDatabase.getAppInstance(application)
        newsDao=db.getNewsDao()
    }

    fun saveNews(article: Article){
        newsDao.saveaNews(article)
    }

    fun getAllNews():List<Article>{
        return newsDao.getNews()
    }
    fun deleteNews(id:Int){
        newsDao.deleteNews(id)
    }
    fun deleteNews2(article: Article){
        newsDao.deleteNews2(article)
    }
    fun clearNews(){
        newsDao.clearNews()
    }

    fun saveNews() {
        TODO("Not yet implemented")
    }
}