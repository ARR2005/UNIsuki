package com.example.unisuki.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.unisuki.R

class login : AppCompatActivity() {

    private lateinit var loginemail: EditText
    private lateinit var loginpassword: EditText
    private lateinit var loginbutton: com.google.android.material.button.MaterialButton
    private lateinit var warningTextView: TextView
    private lateinit var signuptext : TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        loginemail = findViewById(R.id.signinEmail)
        loginpassword = findViewById(R.id.password)
        loginbutton = findViewById(R.id.btn_login)
        warningTextView = findViewById(R.id.warning)
        signuptext = findViewById(R.id.tv_login)


        loginbutton.setOnClickListener {
            val email = loginemail.text.toString()
            val password = loginpassword.text.toString()

            if (email.isEmpty() || password.isEmpty()) {
                warningTextView.text = "Please fill all the fields"
                warningTextView.visibility = View.VISIBLE
            } else {
                warningTextView.visibility = View.GONE

                // --- FIX IS HERE ---
                // 1. Create an Intent to go to MainActivity, NOT a Fragment.
                val intent = Intent(this, MainActivity::class.java)

                // 2. Attach an "extra" to tell MainActivity which fragment to show first.
                intent.putExtra("fragmentToLoad", "DASHBOARD")

                // 3. Start MainActivity.
                startActivity(intent)

                // 4. Finish the login activity so the user cannot press "back" to return to it.
                finish()
            }
        }

        signuptext.setOnClickListener {
            // Create an Intent to open SignupActivity
            val intent = Intent(this, signup::class.java) // Make sure SignupActivity exists
            startActivity(intent)
        }

        }
    }
