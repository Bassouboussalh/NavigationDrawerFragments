package com.boussalh.navigationdrawerfragments

import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.boussalh.navigationdrawerfragments.fragments.ChatFragment
import com.boussalh.navigationdrawerfragments.fragments.MessageFragment
import com.boussalh.navigationdrawerfragments.fragments.ProfileFragment
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var drawer: DrawerLayout
    private lateinit var toolbar: Toolbar
    private lateinit var navigationView: NavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        drawer = findViewById(R.id.drawer)
        toolbar = findViewById(R.id.toolbar)
        navigationView = findViewById(R.id.nav_view)

        setSupportActionBar(toolbar)
        val toogle = ActionBarDrawerToggle(
            this@MainActivity, drawer, toolbar,
            R.string.navigation_drawer_open, R.string.text_menu_drawer_close
        )
        drawer.addDrawerListener(toogle)
        toogle.syncState()

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, MessageFragment()).commit()

        navigationView.setNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_message -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, MessageFragment()).commit()
                }

                R.id.nav_chat -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, ChatFragment()).commit()
                }

                R.id.nav_profile -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, ProfileFragment()).commit()
                }

                R.id.nav_send -> {
                    Toast.makeText(this@MainActivity, "Send Clicked", Toast.LENGTH_SHORT).show()
                }

                R.id.nav_share -> {
                    Toast.makeText(this@MainActivity, "Share Clicked", Toast.LENGTH_SHORT).show()
                }
            }
            drawer.closeDrawer(GravityCompat.START)
            true
        }
    }

    override fun onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START)
        }else{
            super.onBackPressed()
        }
    }
}