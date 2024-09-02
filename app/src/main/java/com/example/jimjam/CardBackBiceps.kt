package com.example.jimjam

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import com.example.jimjam.databinding.ActivityCardBackBicepsBinding

class CardBackBiceps : AppCompatActivity() {
    private lateinit var binding: ActivityCardBackBicepsBinding
    private val totalExercises = 6 // Update this if you add or remove exercises

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCardBackBicepsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Toast.makeText(this, "Tap on exercise to track your progress", Toast.LENGTH_SHORT).show()

        setupCardClickListener(binding.cardLatPulldowns)
        setupCardClickListener(binding.cardSeatedCableRow)
        setupCardClickListener(binding.cardBarbelRow)
        setupCardClickListener(binding.cardDumbbellCurl)
        setupCardClickListener(binding.cardHammerCurl)
        setupCardClickListener(binding.cardConcentrationCurl)
    }

    private fun setupCardClickListener(cardView: CardView) {
        cardView.setOnClickListener {
            val id = cardView.id
            val completedExercises = ExerciseProgressUtil.getCompletedExercises(this)

            if (completedExercises.contains(id)) {
                Toast.makeText(this, "You already completed this exercise", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            ExerciseProgressUtil.addCompletedExercise(this, id)
            cardView.setCardBackgroundColor(ContextCompat.getColor(this, R.color.green)) // Change to green color

            // Calculate and show progress
            val updatedCompletedExercises = ExerciseProgressUtil.getCompletedExercises(this)
            val progressPercentage = (updatedCompletedExercises.size * 100) / totalExercises
            Toast.makeText(this, "Exercise completed! Progress: $progressPercentage%", Toast.LENGTH_SHORT).show()
        }
    }
}
