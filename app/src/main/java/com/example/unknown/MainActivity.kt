package com.example.unknown

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.anonposts.UnknownActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Find views
        val signInTextView: TextView = findViewById(R.id.sign_in_text)
        val emailEditText: EditText = findViewById(R.id.email_edit_text)
        val passwordEditText: EditText = findViewById(R.id.password_edit_text)
        val signInButton: Button = findViewById(R.id.sign_in_button)
        val dontHaveAccountTextView: TextView = findViewById(R.id.dont_have_account_text)
        val signUpButton: TextView = findViewById(R.id.sign_up_text)

        // Set up click listener for Sign In button
        signInButton.setOnClickListener {
            // Validate input
            val email = emailEditText.text.toString().trim()
            val password = passwordEditText.text.toString().trim()

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Please enter your email and password", Toast.LENGTH_SHORT).show()
            } else {
                // Show a toast message and navigate to UnknownActivity on successful sign-in
                Toast.makeText(this, "Signing in...", Toast.LENGTH_SHORT).show()
                val intent = Intent(this@MainActivity, UnknownActivity::class.java)
                startActivity(intent)
                finish() // Optional: finish this activity to prevent going back
            }
        }

        // Set up click listener for Sign Up button
        signUpButton.setOnClickListener {
            // Create an Intent to navigate to SignUpActivity
            val intent = Intent(this@MainActivity, SignUpActivity::class.java)
            startActivity(intent)
        }
    }
}
