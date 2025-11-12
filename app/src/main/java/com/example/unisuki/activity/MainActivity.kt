package com.example.unisuki.activity

import android.content.Intent
import android.os.Bundle
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.unisuki.fragment.Fragment_chat
import com.example.unisuki.fragment.Fragment_dashboard
import com.example.unisuki.fragment.Fragment_notification
import com.example.unisuki.fragment.Fragment_profile
import com.example.unisuki.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var bottomNavigationView: BottomNavigationView
    private lateinit var framelayout : FrameLayout


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNavigationView = findViewById(R.id.bottom_navigation)
        framelayout = findViewById(R.id.fragment_container)

        if (savedInstanceState == null) {
            replaceFragment(Fragment_dashboard())
        }


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
                    val intent = Intent(this, camera::class.java)
                    startActivity(intent)
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
            .commit()
    }

}