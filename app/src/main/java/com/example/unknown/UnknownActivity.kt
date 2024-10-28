package com.example.unknown

import com.example.unknown.FeedbackFormActivity
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class UnknownActivity : AppCompatActivity() {

    private lateinit var editTextPost: EditText
    private lateinit var buttonPost: Button
    private lateinit var linearLayoutPosts: LinearLayout
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var hamburgerButton: ImageView
    private lateinit var navigationView: NavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_unknown)

        // Ensure the IDs match your layout file
        editTextPost = findViewById(R.id.EditTextPost)
        buttonPost = findViewById(R.id.ButtonPost)
        linearLayoutPosts = findViewById(R.id.linearLayoutComments)
        drawerLayout = findViewById(R.id.drawerLayout)
        hamburgerButton = findViewById(R.id.hamburgerButton)
        navigationView = findViewById(R.id.navigationView)

        buttonPost.setOnClickListener {
            val postContent = editTextPost.text.toString().trim()

            if (postContent.isNotEmpty()) {
                addPost(postContent)
                editTextPost.text.clear() // Clear input after posting
            }
        }

        hamburgerButton.setOnClickListener {
            Log.d("UnknownActivity", "Hamburger button clicked")
            if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
                drawerLayout.closeDrawer(GravityCompat.START)
            } else {
                drawerLayout.openDrawer(GravityCompat.START)
            }
        }

        navigationView.setNavigationItemSelectedListener { it ->
            when (it.itemId) {
                R.id.nav_profile -> {
                    val intent = Intent(this, Profile::class.java)
                    startActivity(intent)
                }
                R.id.termsTextView -> {
                    val intent = Intent(this, Terms_policy::class.java)
                    startActivity(intent)
                }
                R.id.nav_logout -> {
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                }
                R.id.nav_about_us -> {
                    val intent = Intent(this,Terms_policy::class.java)
                    startActivity(intent)
                }
                R.id.nav_feedback -> {
                    val intent = Intent(this,FeedbackFormActivity::class.java)
                    startActivity(intent)
                }
            }
            drawerLayout.closeDrawers()
            true
        }
    }

    private fun addPost(content: String) {
        // Create a new post container (LinearLayout with padding)
        val postContainer = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            setPadding(16, 16, 16, 16) // Padding inside the post container
        }

        // Create a horizontal layout for the profile image and text content
        val postLayout = LinearLayout(this).apply {
            orientation = LinearLayout.HORIZONTAL
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            setPadding(10, 0, 0, 0) // Padding inside post layout
        }

        // Create ImageView for profile image
        val profileImageView = ImageView(this).apply {
            setImageResource(R.drawable.pra) // Replace with actual image
            layoutParams = LinearLayout.LayoutParams(
                60, // Width
                60  // Height
            ).apply {
                setMargins(10, 5, 10, 5) // Positioning margins
            }
        }

        // Create a vertical layout for username and post content
        val textLayout = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            layoutParams = LinearLayout.LayoutParams(
                0,
                LinearLayout.LayoutParams.WRAP_CONTENT,
                1f // Fill remaining space
            )
        }

        // Create TextView for username
        val usernameTextView = TextView(this).apply {
            text = "Anonymous" // Change if usernames are dynamic
            textSize = 16f
            setTextColor(resources.getColor(android.R.color.black))
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            ).apply {
                setMargins(0, 0, 0, 5) // Space below username
            }
        }

        // Create TextView for post content
        val postContentTextView = TextView(this).apply {
            text = content
            textSize = 18f
            setTextColor(resources.getColor(android.R.color.black))
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
        }

        // Add username and content TextViews to the text layout
        textLayout.addView(usernameTextView)
        textLayout.addView(postContentTextView)

        // Add profile image and text layout to the post layout
        postLayout.addView(profileImageView)
        postLayout.addView(textLayout)

        // Create delete TextView for post
        val deleteTextView = TextView(this).apply {
            text = "Delete"
            textSize = 14f
            setTextColor(Color.RED) // Red color for delete button
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            ).apply {
                gravity = Gravity.END // Align to right
                setMargins(8, 0, 0, 0)
            }
            setOnClickListener {
                linearLayoutPosts.removeView(postContainer) // Remove the post when clicked
            }
        }

        // Add delete TextView to post layout
        postLayout.addView(deleteTextView)

        // Add post layout to the post container
        postContainer.addView(postLayout)

        // Create a scrollable comment section
        val commentContainer = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
        }

        // Create a ScrollView for the comment section
        val scrollView = ScrollView(this).apply {
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                200 // Fixed height for comment section
            )
            isVerticalScrollBarEnabled = false
            addView(commentContainer) // Add comment container to ScrollView
        }

        // Create a layout for adding comments
        val commentLayout = LinearLayout(this).apply {
            orientation = LinearLayout.HORIZONTAL
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            setPadding(0, 5, 0, 0) // Padding above comment input
        }

        // Create EditText for entering a comment
        val editTextComment = EditText(this).apply {
            layoutParams = LinearLayout.LayoutParams(
                0,
                LinearLayout.LayoutParams.WRAP_CONTENT,
                1f // Use weight to fill remaining space
            )
            hint = "Add a comment..."
            setPadding(8, 8, 8, 8)
        }

        // Create a button for submitting the comment
        val buttonComment = Button(this).apply {
            text = "Comment"
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            ).apply {
                setMargins(8, 0, 0, 0) // Spacing margin
            }
            setOnClickListener {
                val commentContent = editTextComment.text.toString().trim()
                if (commentContent.isNotEmpty()) {
                    addComment(commentContainer, commentContent, "YourUsername") // Pass a username
                    editTextComment.text.clear() // Clear the comment input after posting
                }
            }
        }

        // Add comment input and button to comment layout
        commentLayout.addView(editTextComment)
        commentLayout.addView(buttonComment)

        // Add ScrollView for comments and the comment layout to post container
        postContainer.addView(scrollView)
        postContainer.addView(commentLayout)

        // Create a border line below each post
        val borderLine = View(this).apply {
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                2 // Height of the border
            )
            setBackgroundColor(Color.GRAY)
        }

        // Add border line below the comment section
        postContainer.addView(borderLine)

        // Add the post container to the linear layout at the top
        linearLayoutPosts.addView(postContainer, 0)
    }

    private fun addComment(commentContainer: LinearLayout, content: String, username: String) {
        // Create a horizontal layout for the comment and delete button
        val commentLayout = LinearLayout(this).apply {
            orientation = LinearLayout.HORIZONTAL
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            setPadding(10, 10, 10, 10)
        }

        // Create the vertical layout for username and comment text
        val commentTextLayout = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            layoutParams = LinearLayout.LayoutParams(
                0,
                LinearLayout.LayoutParams.WRAP_CONTENT,
                1f // Fill remaining space
            )
        }

        // Create TextView for username
        val usernameTextView = TextView(this).apply {
            text = username // Dynamic username
            textSize = 14f
            setTextColor(Color.BLACK)
        }

        // Create TextView for comment content
        val commentContentTextView = TextView(this).apply {
            text = content
            textSize = 14f
            setTextColor(Color.DKGRAY)
        }

        // Add username and comment content to the vertical layout
        commentTextLayout.addView(usernameTextView)
        commentTextLayout.addView(commentContentTextView)

        // Create delete TextView for comment
        val deleteCommentTextView = TextView(this).apply {
            text = "Delete"
            textSize = 12f
            setTextColor(Color.RED)
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            ).apply {
                setMargins(8, 0, 0, 0) // Margin for positioning
            }
            setOnClickListener {
                commentContainer.removeView(commentLayout) // Remove the comment when clicked
            }
        }

        // Add username and comment text to the comment layout
        commentLayout.addView(commentTextLayout)
        commentLayout.addView(deleteCommentTextView)

        // Add the comment layout to the comment container
        commentContainer.addView(commentLayout)
    }
}

