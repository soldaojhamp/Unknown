package com.example.unknown

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class SignUpCreateActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Apply window insets to adjust padding
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //* Initialize UI components

        val nicknameEditText:EditText = findViewById(R.id.Nickname_Edit_Text)
        val signUpButton: Button = findViewById(R.id.sign_up_button)


        // Set click listener for the sign-up button
        signUpButton.setOnClickListener {
            val nickname = nicknameEditText.text.toString()
            // TODO: Implement sign up logic with nickname
        }
    }
}
