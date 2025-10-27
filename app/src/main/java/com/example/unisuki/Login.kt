package com.example.unisuki

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.example.unisuki.databinding.ActivityLoginBinding // <-- This is auto-generated from your layout file

class LoginActivity : AppCompatActivity() {

    // Setup View Binding
    private lateinit var binding: ActivityLoginBinding

    // Setup Firebase Database reference
    private lateinit var database: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inflate the layout
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize Firebase reference to the "users" node
        database = FirebaseDatabase.getInstance().getReference("users")

        // Set click listener for the login button
        binding.btnLogin.setOnClickListener {
            loginUser()
        }

        // Set click listener for the "here" (sign up) text
        binding.tvSignup.setOnClickListener {
            // This is where you would open your SignUpActivity
            // val intent = Intent(this, SignUpActivity::class.java)
            // startActivity(intent)
            Toast.makeText(this, "Sign up clicked!", Toast.LENGTH_SHORT).show()
        }
    }

    private fun loginUser() {
        val loginText = binding.etLogin.text.toString().trim()
        val password = binding.etPassword.text.toString().trim()

        if (loginText.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Please enter login and password", Toast.LENGTH_SHORT).show()
            return
        }

        // --- Firebase Key Encoding ---
        // Firebase keys (like usernames) CANNOT contain '.', '#', '$', '[]', or '/'.
        // Since the user is entering an email, we must "encode" it.
        // A simple way is to replace '.' with ','.
        val encodedLogin = loginText.replace(".", ",")

        // Query the database for the user
        database.child(encodedLogin).addListenerForSingleValueEvent(object : ValueEventListener {

            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    // User was found in the database
                    // Now, get the stored password
                    val storedPassword = snapshot.child("password").getValue(String::class.java)

                    if (storedPassword == password) {
                        // Password matches!
                        Toast.makeText(baseContext, "Login Successful!", Toast.LENGTH_SHORT).show()

                        // TODO: Navigate to your app's main screen
                        // val intent = Intent(this@LoginActivity, MainActivity::class.java)
                        // startActivity(intent)
                        // finish() // Close the login activity

                    } else {
                        // Password does not match
                        Toast.makeText(baseContext, "Incorrect password", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    // User was not found
                    Toast.makeText(baseContext, "User not found", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onCancelled(error: DatabaseError) {
                // An error occurred
                Toast.makeText(baseContext, "Database error: ${error.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }
}