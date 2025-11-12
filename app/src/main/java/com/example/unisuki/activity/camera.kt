package com.example.unisuki.activity

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.unisuki.R

class camera : AppCompatActivity() {

    private lateinit var camera_Button: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_camera)

        camera_Button = findViewById(R.id.cameraButton)
        camera_Button.setOnClickListener {
            val intent = Intent(this, post::class.java)
            startActivity(intent)
        }
    }
}