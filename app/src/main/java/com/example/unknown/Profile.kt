package com.example.unknown

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import android.widget.Toast

class Profile : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_profile)

        val imageViewBack: ImageView = findViewById(R.id.imageViewBack)
        val buttonDeleteAccount: Button = findViewById(R.id.buttonDeleteAccount) // Add your delete button

        imageViewBack.setOnClickListener {
            // Navigate back to UnknownActivity when back is clicked
            val intent = Intent(this, UnknownActivity::class.java)
            startActivity(intent)
        }

        buttonDeleteAccount.setOnClickListener {
            // Handle your account deletion process here
            deleteAccount() // Call this function when delete button is clicked
        }
    }

    // Dummy account deletion logic (replace with your own)
    private fun deleteAccount() {
        // Perform your account deletion logic here, then navigate to Sign In page
        Toast.makeText(this, "Account deleted successfully", Toast.LENGTH_SHORT).show()

        // Navigate to Sign In page
        val intent = Intent(this, SignUpActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
        finish() // Close current activity
    }
}
