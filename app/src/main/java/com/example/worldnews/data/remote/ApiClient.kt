package com.example.worldnews.data.remote

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object ApiClient {

    private val isTester = true
    private val SERVER_PRODUCTION = "https://newsapi.org/v2/"
    private val SERVER_DEVELOPMENT = "https://newsapi.org/v2/"
    private val country = "us"
    private val newsKey = "f5f77f7d5e724c8cacffc01fce1e5380"


    private val retrofit: Retrofit = Retrofit.Builder().baseUrl(baseUrl())
        .addConverterFactory(
            GsonConverterFactory.create()
        ).client(getNews()).build()

    val apiService = retrofit.create(ApiService::class.java)


    private fun getNews(): OkHttpClient {
        return OkHttpClient.Builder().addInterceptor(Interceptor { chain ->
            val builder = chain.request().newBuilder()
            builder.addHeader(country, newsKey)
            chain.proceed(builder.build())
        })
            .build()
    }

    private fun baseUrl(): String {
        return if (isTester) SERVER_DEVELOPMENT
        else SERVER_PRODUCTION
    }
}
