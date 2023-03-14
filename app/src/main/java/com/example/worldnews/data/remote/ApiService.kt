package com.example.worldnews.data.remote

import com.example.worldnews.model.news.New
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("top-headlines")
    fun getNews(
        @Query("country")country:String="us",
        @Query("apiKey") apiKey:String="f5f77f7d5e724c8cacffc01fce1e5380"
    ): Call<New>

//    @GET("top-headlines")
//    fun getNewsById(
//        @Path("id") id:String,
//        @Query("apiKey") apiKey: String="f5f77f7d5e724c8cacffc01fce1e5380"
//    ):Call<Article>

}