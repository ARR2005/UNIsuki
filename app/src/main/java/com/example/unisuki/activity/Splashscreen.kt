package com.example.unisuki.activity

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity
import com.example.unisuki.R

class Splashscreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash)

        val videoView = findViewById<VideoView>(R.id.videoView)
        val getStartedButton = findViewById<Button>(R.id.SplashscreenButton)

        // Set the path for the video file from the 'raw' directory
        // Make sure you have a video named 'splash_video.mp4' in your res/raw folder
        val videoPath = "android.resource://" + packageName + "/" + R.raw.splash_animation

        val uri = Uri.parse(videoPath)

        // Set the URI to the VideoView
        videoView.setVideoURI(uri)

        // Set a listener to know when the video has finished playing
        videoView.setOnCompletionListener {
            // When the video is done, make the button visible
            getStartedButton.visibility = View.VISIBLE
        }

        // Set a click listener for the button
        getStartedButton.setOnClickListener {
            // Navigate to your main activity
            // IMPORTANT: Replace MainActivity::class.java with your actual main activity
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
            // Call finish() to prevent returning to this screen
            finish()
        }

        // Start playing the video
        videoView.start()
    }
}
