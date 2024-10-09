package com.example.unknown

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

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
        val signUpTextView: TextView = findViewById(R.id.sign_up_text)
        val createEmailEditText: EditText = findViewById(R.id.create_email_edit_text)
        val createPasswordEditText: EditText = findViewById(R.id.create_password_edit_text)
        val signUpButton: Button = findViewById(R.id.sign_up_button)
        val alreadyHaveAccountTextView: TextView = findViewById(R.id.already_have_account_text)
        val logInButton: Button = findViewById(R.id.log_in_button)

        // Set up listeners or actions if needed
    }
}
