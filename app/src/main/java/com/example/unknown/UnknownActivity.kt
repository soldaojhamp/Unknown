package com.example.anonposts

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.unknown.R

class UnknownActivity : AppCompatActivity() {

    private lateinit var editTextPost: EditText
    private lateinit var buttonPost: Button
    private lateinit var linearLayoutPosts: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Ensure the IDs match your layout file
        editTextPost = findViewById(R.id.EditTextPost) // Correct ID reference
        buttonPost = findViewById(R.id.ButtonPost)
        linearLayoutPosts = findViewById(R.id.LinearLayoutFirstPost)

        buttonPost.setOnClickListener {
            val postContent = editTextPost.text.toString().trim()

            if (postContent.isNotEmpty()) {
                addPost(postContent)
                editTextPost.text.clear() // Clear input after posting
            }
        }
    }

    private fun addPost(content: String) {
        // Create a new post layout
        val newPostView = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            setPadding(0, 16, 0, 16) // Add padding between posts
        }

        // Create the username TextView
        val usernameTextView = TextView(this).apply {
            text = "Anonymous"
            textSize = 16f
            setTextColor(resources.getColor(android.R.color.black))
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            ).apply {
                setMargins(50, 5, 10, 0) // Add margin for positioning
            }
        }

        // Create the post content TextView
        val postContentTextView = TextView(this).apply {
            text = content
            textSize = 18f
            setTextColor(resources.getColor(android.R.color.black))
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            ).apply {
                setMargins(10, 0, 0, 0) // Align text properly
            }
        }

        // Add TextViews to the new post layout
        newPostView.addView(usernameTextView)
        newPostView.addView(postContentTextView)

        // Add the new post to the linear layout for recent posts
        linearLayoutPosts.addView(newPostView)
    }
}
