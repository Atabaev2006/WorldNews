package com.example.worldnews.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.worldnews.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupBottomNavigation()
    }

    private fun setupBottomNavigation() {
        val navHostFragment=supportFragmentManager.findFragmentById(R.id.NavigationGraphFrogment) as NavHostFragment
        findViewById<BottomNavigationView>(R.id.bottomNavigationView).setupWithNavController(navHostFragment.navController)
    }


}