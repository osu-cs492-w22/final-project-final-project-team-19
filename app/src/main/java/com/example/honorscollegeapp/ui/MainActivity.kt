package com.example.honorscollegeapp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.honorscollegeapp.R
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {
//    private lateinit var appBarConfiguration: AppBarConfiguration
    lateinit var navController: NavController
    lateinit var drawerLayout: DrawerLayout
    lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar: Toolbar = findViewById(R.id.toolbar_layout)
        setSupportActionBar(toolbar)

        val navHostFragment: NavHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_fragment) as NavHostFragment
        val navController = navHostFragment.navController
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        appBarConfiguration = AppBarConfiguration(navController.graph, drawerLayout)
        setupActionBarWithNavController(navController, appBarConfiguration)
        findViewById<NavigationView>(R.id.nav_top_view).setupWithNavController(navController)


//        navController = findNavController(R.id.nav_fragment)
//        drawerLayout = findViewById(R.id.drawer_layout)
//        appBarConfiguration = AppBarConfiguration(navController.graph, drawerLayout)
//
//        findViewById<NavigationView>(R.id.nav_top_view).setupWithNavController(navController)
//        setupActionBarWithNavController(navController, appBarConfiguration)
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
//        val navController = findNavController(R.id.nav_fragment)
//        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}