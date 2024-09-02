package com.example.jimjam

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.jimjam.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var binding: ActivityMainBinding

    // Track completed exercises
    private var totalExercises = 0
    private var completedExercises = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        auth = Firebase.auth
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize totalExercises based on your actual exercises
        totalExercises = 18 // Example: adjust based on your actual exercise count
        completedExercises = 0

        updateProgress()


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
                startActivity(Intent(this, LoginAvitivity::class.java))
                finish()
            } catch (e: Exception) {
                Log.e("SignOutError", "Error signing out: ${e.message}")
                Toast.makeText(this, "Sign out failed", Toast.LENGTH_SHORT).show()
            }
        }
    }
    override fun onResume() {
        super.onResume()
        updateProgress()
    }

    private fun updateProgress() {
        val completedExercises = ExerciseProgressUtil.getCompletedExercises(this)
        val progressPercentage = (completedExercises.size * 100) / totalExercises
        binding.progressTextView.text = "Progress: $progressPercentage%"
    }


    // Call this function whenever an exercise is completed
    private fun onExerciseCompleted() {
        completedExercises++
        updateProgress()
        Toast.makeText(this, "Exercise completed! Progress: ${(completedExercises * 100) / totalExercises}%", Toast.LENGTH_SHORT).show()
    }
}
