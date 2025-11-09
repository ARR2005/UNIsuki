package com.example.unisuki.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.unisuki.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var bottomNavigationView: BottomNavigationView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNavigationView = findViewById(R.id.bottom_navigation)

        bottomNavigationView.setOnItemSelectedListener { menuItem ->
            when(menuItem.itemId) {
                R.id.navDashboard -> {
                    replaceFragment(Fragment_dashboard())
                    true
                }

                R.id.navChat -> {
                    replaceFragment(Fragment_chat())
                    true
                }

                R.id.navCart -> {
                    replaceFragment(Fragment_cart())
                    true
                }

                R.id.navNotification -> {
                    replaceFragment(Fragment_notification())
                    true
                }

                R.id.navProfile -> {
                    replaceFragment(Fragment_profile())
                    true
                }

                else -> false
            }
        }
        replaceFragment(Fragment_dashboard())
    }
    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
    }

}