package com.example.unisuki.activity

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import com.example.unisuki.R

class splashScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContentView(R.layout.activity_splash_screen)

        val videoView = findViewById<VideoView>(R.id.videoView)
        val path = "android.resource://" + packageName + "/" + R.raw.unisuki
        videoView.setVideoURI(Uri.parse(path))

        videoView.setOnPreparedListener { mp ->
            mp.setVolume(0f, 0f)
        }

        videoView.setOnCompletionListener {
            startActivity(Intent(this@splashScreen, login::class.java))
            finish()
        }
        videoView.start()
    }
}