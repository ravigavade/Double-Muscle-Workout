package com.example.jimjam

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_splash_screen)

        // Delay for 2 seconds (2000 milliseconds) and then start MainActivity
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this@SplashScreen, LoginAvitivity::class.java)
            startActivity(intent)
            finish() // Close SplashScreen so it won't be in the back stack
        }, 1500)

    }
}