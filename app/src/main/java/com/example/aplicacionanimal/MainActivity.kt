package com.example.aplicacionanimal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.aplicacionanimal.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var listIntent: Intent
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //val boton: Button = findViewById(R.id.boton)

        binding.boton.setOnClickListener { launchVertical() }
    }

    private fun launchVertical() {
        listIntent = Intent(this, MenuLogica::class.java)
        startActivity(listIntent)
    }
}

