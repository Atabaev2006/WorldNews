package com.example.worldnews.data.remote

import androidx.room.Delete
import com.example.worldnews.model.News
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface ApiSevice {

   @GET("everything -G")
   fun getAllEveverything(): Call<ArrayList<News>>

   @GET("everythings -G/{id")
   fun getEverethingById(@Path("id") id:Int):Call<News>


   @POST("everething -G")
   fun saveEverething(@Body news: News):Call<News>


   @PUT("everething -G")
   fun updateEverething(@Path("id") id:Int,@Body news: News):Call<News>


   @DELETE("everething -G/{id}")
   fun deleteEverething(@Path("id") id: Int)






}