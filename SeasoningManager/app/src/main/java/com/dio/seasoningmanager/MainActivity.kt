package com.dio.seasoningmanager

import android.content.Context
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import android.widget.ImageButton
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.dio.seasoningmanager.state.toolbar.AddToolbarState
import com.dio.seasoningmanager.state.toolbar.BaseToolbarState
import com.dio.seasoningmanager.state.toolbar.ListToolbarState

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        val navController = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        AppBarConfiguration(setOf(
                R.id.navigation_list, R.id.navigation_setting))
        navView.setupWithNavController(navController.navController)

    }
}
