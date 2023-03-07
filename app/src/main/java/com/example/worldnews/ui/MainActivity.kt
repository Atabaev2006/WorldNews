package com.example.worldnews.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.worldnews.R
import com.example.worldnews.data.remote.ApiClient
import com.example.worldnews.model.News
import com.google.android.material.bottomnavigation.BottomNavigationView
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class MainActivity : AppCompatActivity() {
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupBottomNavigation()
    }
    private fun setupBottomNavigation() {
        val navHostFragment=supportFragmentManager.findFragmentById(R.id.NavigationGraphFrogment) as NavHostFragment
        findViewById<BottomNavigationView>(R.id.bottomNavigationView).setupWithNavController(navHostFragment.navController)

        initView()
    }

    private fun initView() {
     loadEverething()

    }

    private fun loadEverething() {
        ApiClient.apiSevice.getAllEveverything().enqueue(object :retrofit2.Callback<ArrayList<News>>{
            override fun onResponse(
                call: Call<ArrayList<News>>,
                response: Response<ArrayList<News>>
            ) {
                if (response.isSuccessful){
                    val list=response.body()
                    list?.forEach {
                        Log.d("@@@@", "onResponse:$it ")


                    }
                }
            }

            override fun onFailure(call: Call<ArrayList<News>>, t: Throwable) {

            }

        })
    }


}