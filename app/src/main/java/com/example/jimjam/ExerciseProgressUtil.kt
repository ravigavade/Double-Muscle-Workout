package com.example.jimjam

import android.content.Context
import android.content.SharedPreferences

object ExerciseProgressUtil {

    private const val PREFS_NAME = "exercise_progress_prefs"
    private const val COMPLETED_EXERCISES_KEY = "completed_exercises"

    fun getCompletedExercises(context: Context): Set<Int> {
        val prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        return prefs.getStringSet(COMPLETED_EXERCISES_KEY, setOf())!!.map { it.toInt() }.toSet()
    }

    fun addCompletedExercise(context: Context, exerciseId: Int) {
        val prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        val completedExercises = getCompletedExercises(context).toMutableSet()
        completedExercises.add(exerciseId)
        prefs.edit().putStringSet(COMPLETED_EXERCISES_KEY, completedExercises.map { it.toString() }.toSet()).apply()
    }

    fun resetProgress(context: Context) {
        val prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        prefs.edit().clear().apply()
    }


}
