package com.learn.firebasechatapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.*
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.learn.firebasechatapp.signinup.SignUp

class MainMenu : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        val firebaseAuth: FirebaseAuth = Firebase.auth
        if (firebaseAuth.currentUser == null) {
            // if not signed up
            // go to sign up activity
            startActivity(Intent(applicationContext, SignUp::class.java))
            finish()
        }

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_menu)

        val bottomNavBar: BottomNavigationView = findViewById(R.id.nav_bar)

        val navController: NavController = Navigation.findNavController(this, R.id.bottom_nav_bar_fragment_view)
        NavigationUI.setupWithNavController(bottomNavBar, navController)
    }
}