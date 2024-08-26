package com.example.jimjam

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.jimjam.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        auth = Firebase.auth

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.BackAndBicepCard.setOnClickListener {
            startActivity(Intent(this, CardBackBiceps::class.java))
        }

        binding.ChestAndTricepsCard.setOnClickListener {
            startActivity(Intent(this, CardChestTricep::class.java))
        }

        binding.ShouldersAndAbsCard.setOnClickListener {
            startActivity(Intent(this, CardShoulderABS::class.java))
        }

        binding.noEbtn.setOnClickListener {
            startActivity(Intent(this, noEquipment::class.java))
        }

        binding.fivemintotbtn.setOnClickListener {
            startActivity(Intent(this, fiveMinAbs::class.java))
        }

        binding.logoutbtn.setOnClickListener {
            try {
                Firebase.auth.signOut()
                // No need to check currentUser after signOut; the user should be logged out.
                startActivity(Intent(this, LoginAvitivity::class.java))
                finish()
            } catch (e: Exception) {
                Log.e("SignOutError", "Error signing out: ${e.message}")
                Toast.makeText(this, "Sign out failed", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
