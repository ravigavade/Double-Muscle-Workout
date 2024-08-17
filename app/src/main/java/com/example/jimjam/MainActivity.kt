package com.example.jimjam

import android.content.Intent
import android.os.Bundle
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
            val intent = Intent(this, CardBackBiceps::class.java)
            startActivity(intent)
        }

//        binding.aboutbtn.setOnClickListener {
//            val intent = Intent(this, About::class.java)
//            startActivity(intent)
//        }

//        binding.fivemintotbtn.setOnClickListener {
//            val intent = Intent(this, fiveMinAbs::class.java)
//            startActivity(intent)
//        }
//
//        binding.noEbtn.setOnClickListener {
//            val intent = Intent(this, noEquipment::class.java)
//            startActivity(intent)
//        }

//        binding.logoutBtn.setOnClickListener {
//            try {
//                Firebase.auth.signOut()
//                if (Firebase.auth.currentUser == null) {
//                    startActivity(Intent(this, LoginAvitivity::class.java))
//                    finish()
//                } else {
//                    Toast.makeText(this, "Sign out failed", Toast.LENGTH_SHORT).show()
//                }
//            } catch (e: Exception) {
//                Log.e("SignOutError", "Error signing out: ${e.message}")
//                Toast.makeText(this, "Sign out failed", Toast.LENGTH_SHORT).show()
//            }
//        }
    }
}
