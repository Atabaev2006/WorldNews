package com.example.worldnews.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {


    val isTester = false
    val SERVER_PRODUCTION = "https://newsapi.org/v2/"
    val SERVER_DEVELOPMENT = ""

    val retrofit = Retrofit.Builder().baseUrl(baseURL())
        .addConverterFactory(GsonConverterFactory.create())
        .build()


    fun baseURL(): String {
        if (isTester)
            return SERVER_DEVELOPMENT
        else {
            return SERVER_PRODUCTION
        }
    }

    val apiSevice= retrofit.create(ApiSevice::class.java)

}