package com.example.worldnews.data.remote

import android.app.appsearch.SearchResult
import com.example.worldnews.model.news.Article
import com.example.worldnews.model.news.Everything
import com.example.worldnews.model.news.New
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("top-headlines")
    fun getNews(
        @Query("page") page: Int =1,
        @Query("country") country: String ="us",
        @Query("apiKey") apiKey:String="f5f77f7d5e724c8cacffc01fce1e5380"
    ): Call<New>

   @GET("everything")
   fun getAllNews(
       @Query("q") q: String="",
       @Query("apiKey") apiKey: String="f5f77f7d5e724c8cacffc01fce1e5380"
   ):Call<Everything>


}