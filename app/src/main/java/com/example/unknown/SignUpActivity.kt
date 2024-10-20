package com.example.unknown

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.anonposts.UnknownActivity


class SignUpActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sign_up)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.signup_main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Find views
        val createEmailEditText: EditText = findViewById(R.id.create_email_edit_text)
        val createPasswordEditText: EditText = findViewById(R.id.create_password_edit_text)
        val createNicknameEditText: EditText = findViewById(R.id.create_nickname_edit_text)
        val signUpButton: Button = findViewById(R.id.sign_up_button)
        val logInButton: TextView = findViewById(R.id.log_in_text)

        // Initialize Retrofit API service

        // Set up click listener for Sign Up button
        signUpButton.setOnClickListener {
            val email = createEmailEditText.text.toString().trim()
            val password = createPasswordEditText.text.toString().trim()
            val nickname = createNicknameEditText.text.toString().trim() // Use the correct EditText for nickname


        }

        // Set up click listener for Log In text
        logInButton.setOnClickListener {
            navigateToLogin()
        }
    }



    private fun navigateToLogin() {
        // Navigate to the MainActivity for login
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish() // Optional: finish this activity to prevent going back
    }
}
