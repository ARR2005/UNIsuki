package com.example.unisuki.activity

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.unisuki.R
import com.google.android.material.button.MaterialButton
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.example.test_unisuki.auth.auth


class signup : AppCompatActivity() {

    private lateinit var signupEmail: EditText
    private lateinit var signupIdNumber: EditText
    private lateinit var signupPassword: EditText
    private lateinit var signupRepassword: EditText
    private lateinit var signupButton: MaterialButton
    private lateinit var loginTextView: TextView

    private lateinit var database: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        // Initialize views
        signupEmail = findViewById(R.id.email)
        signupIdNumber = findViewById(R.id.idNumber)
        signupPassword = findViewById(R.id.password)
        signupRepassword = findViewById(R.id.repassword)
        signupButton = findViewById(R.id.btn_signup)
        loginTextView = findViewById(R.id.tv_signup)



        // This is the recreated Kotlin click listener
        signupButton.setOnClickListener {
            // Get the text from the EditText fields
            val email = signupEmail.text.toString()
            val idNumber = signupIdNumber.text.toString()
            val password = signupPassword.text.toString()
            val repassword = signupRepassword.text.toString()

            // --- Basic Validation ---
            if (email.isEmpty() || idNumber.isEmpty() || password.isEmpty() || repassword.isEmpty()) {
                Toast.makeText(this, "All fields are required", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (password != repassword) {
                Toast.makeText(this, "Passwords do not match", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            database = FirebaseDatabase.getInstance().getReference("Users")

            val user = auth(email, idNumber, password, repassword)

            database.child(idNumber).setValue(user).addOnSuccessListener {
                Toast.makeText(this, "Signed up successfully!", Toast.LENGTH_SHORT).show()

                val intent = Intent(this, login::class.java)
                startActivity(intent)
                finish()

            }.addOnFailureListener { exception ->

                Toast.makeText(this, "Signup failed: ${exception.message}", Toast.LENGTH_SHORT).show()
            }


        }

        loginTextView.setOnClickListener {
            val intent = Intent(this, login::class.java)
            startActivity(intent)
        }
    }
}
