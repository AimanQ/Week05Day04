package com.example.week05day04

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    private var drawerLayout:DrawerLayout?= null
    private var toolbarView: Toolbar?= null
    private var navigationView:NavigationView?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        connectViews()

        setSupportActionBar(toolbarView!!)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        setupDrawer()
        drawerClicks()

    }
    private fun connectViews(){
        drawerLayout = findViewById(R.id.drawer)
        toolbarView = findViewById(R.id.toolbar)
        navigationView = findViewById(R.id.navView)
    }
    private fun setupDrawer(){
        /*
        1) this (context)
        2) DrawerLayout
        3) String open
        4) String close
         */
        val toggleDrawer = ActionBarDrawerToggle(this,drawerLayout!!,R.string.open,R.string.close)
        drawerLayout?.addDrawerListener(toggleDrawer)
        toggleDrawer.syncState()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            android.R.id.home ->{
                drawerLayout?.openDrawer(GravityCompat.START)
                true
            }
            else -> true
        }
    }

    private fun drawerClicks(){
        navigationView?.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.camera ->{
                    Toast.makeText(this,"Open Camera",Toast.LENGTH_LONG).show()
                    drawerLayout?.closeDrawer(GravityCompat.START)
                    true
                }
                R.id.gallery ->{
                    Toast.makeText(this,"Open Gallery",Toast.LENGTH_LONG).show()
                    drawerLayout?.closeDrawer(GravityCompat.START)
                    true
                }
                R.id.send ->{
                    Toast.makeText(this,"Send",Toast.LENGTH_LONG).show()
                    drawerLayout?.closeDrawer(GravityCompat.START)
                    true
                }
                R.id.share ->{
                    Toast.makeText(this,"Share",Toast.LENGTH_LONG).show()
                    drawerLayout?.closeDrawer(GravityCompat.START)
                    true
                }
                else -> true
            }
        }
    }
}