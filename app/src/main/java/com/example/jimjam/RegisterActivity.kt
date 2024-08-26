package com.example.jimjam

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.jimjam.databinding.ActivityRegisterBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding
    private lateinit var auth: FirebaseAuth

    companion object {
        private const val TAG = "RegisterActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = Firebase.auth

        binding.continueBtn.setOnClickListener {
            val email = binding.mail.text.toString().trim()
            val password = binding.password.text.toString().trim()

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(baseContext, "Email and Password are required.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        Log.d(TAG, "createUserWithEmail:success")
                        // Redirect to LoginAvitivity after successful registration
                        startActivity(Intent(this, LoginAvitivity::class.java))
                        finish() // Ensure the RegisterActivity is finished
                    } else {
                        Log.w(TAG, "createUserWithEmail:failure", task.exception)
                        Toast.makeText(baseContext, "Authentication failed.", Toast.LENGTH_SHORT).show()
                    }
                }
        }

        binding.move.setOnClickListener {
            startActivity(Intent(this, LoginAvitivity::class.java))
            finish() // Ensure the RegisterActivity is finished
        }
    }

    override fun onStart() {
        super.onStart()
        // Optionally, you can check if the user is already logged in
        val currentUser = auth.currentUser
        if (currentUser != null) {
            // You can add logic here if needed, but typically this should be handled in LoginAvitivity or MainActivity
        }
    }
}
