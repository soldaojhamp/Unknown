package com.example.unknown

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import androidx.appcompat.widget.Toolbar
import android.view.MenuItem
import android.view.View
import android.widget.ImageView // Assume you are using an ImageView for the hamburger icon

class PostingActivity : AppCompatActivity() {

    private lateinit var drawerLayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge() // Enable edge-to-edge display
        setContentView(R.layout.activity_posting)

        // Setup DrawerLayout and Toolbar
        drawerLayout = findViewById(R.id.drawer_layout)



        // Enable the hamburger icon in the toolbar
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)

        // Example: Add custom click listener to open drawer
        val hamburgerIcon: ImageView = findViewById(R.id.hamburgerButton) // Assuming you have a custom ImageView for hamburger
        hamburgerIcon.setOnClickListener {
            drawerLayout.openDrawer(findViewById<NavigationView>(R.id.nav_view)) // Open navigation drawer
        }

        // Handle navigation item clicks
        val navigationView: NavigationView = findViewById(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.nav_home -> {
                    // Handle Home menu item
                }
                R.id.nav_profile -> {
                    // Handle Profile menu item
                }
                // Other menu items
            }
            drawerLayout.closeDrawers() // Close the drawer after selection
            true
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            drawerLayout.open() // Open the drawer when the home button is clicked
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}
