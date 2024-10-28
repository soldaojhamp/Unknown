package com.example.unknown

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.unknown.R

class FeedbackFormActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feedback_form)


        // Initialize views
        val closeButton: TextView = findViewById(R.id.btn_close)
        val submitButton: Button = findViewById(R.id.btn_submit_feedback)
        val suggestionEditText: EditText = findViewById(R.id.et_suggestion)
        val additionalFeedbackEditText: EditText = findViewById(R.id.et_additional_feedback)

        // Close button functionality
        closeButton.setOnClickListener {
            finish()  // Closes the activity
        }

        // Submit feedback functionality
        submitButton.setOnClickListener {
            val suggestion = suggestionEditText.text.toString()
            val additionalFeedback = additionalFeedbackEditText.text.toString()

            if (suggestion.isNotBlank() || additionalFeedback.isNotBlank()) {
                // Show confirmation (can replace with actual feedback handling logic)
                Toast.makeText(
                    this,
                    "Thank you for your feedback!",
                    Toast.LENGTH_SHORT
                ).show()

                // Optional: Clear input fields after submission
                suggestionEditText.text.clear()
                additionalFeedbackEditText.text.clear()
            } else {
                // Prompt user to enter feedback if both fields are empty
                Toast.makeText(
                    this,
                    "Please enter feedback before submitting.",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}
