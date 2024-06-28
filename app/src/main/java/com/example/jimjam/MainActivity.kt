package com.example.jimjam

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.jimjam.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.doubleMusclebtn.setOnClickListener{
            val intent=Intent(this, DoubleMuscle::class.java )
            startActivity(intent)
        }

        binding.aboutbtn.setOnClickListener {
            val intent=Intent(this,About::class.java)
            startActivity(intent)
        }

        binding.fivemintotbtn.setOnClickListener {
            val intent=Intent(this,fiveMinAbs::class.java)
            startActivity(intent)
        }

        binding.noEbtn.setOnClickListener {
            val intent=Intent(this,noEquipment::class.java)
            startActivity(intent)
        }
    }
}