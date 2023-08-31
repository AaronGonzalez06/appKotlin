package com.example.aplicacionanimal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.animales.adapter.AnimalAdapter
import com.example.aplicacionanimal.data.AnimalProvider

class TodoAnimales : AppCompatActivity() {
    private lateinit var listIntent: Intent
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.todo_animales)
        initRecyclerView()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun initRecyclerView() {
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerAnimal)
        recyclerView.layoutManager = LinearLayoutManager(this)
        //recyclerView.layoutManager = GridLayoutManager(this,2)
        val valorDado = intent.getStringExtra("filtroValor")

        if (valorDado == "ave") {
            val listaDeAves = AnimalProvider.animalesList.filter { it.especieAnimal == "ave" }
            recyclerView.adapter = AnimalAdapter(listaDeAves )
        } else if (valorDado == "Mamifero") {
            val listaDeGatos = AnimalProvider.animalesList.filter { it.especieAnimal == "Mamifero" }
            recyclerView.adapter = AnimalAdapter(listaDeGatos )
        } else if (valorDado == "Reptil") {
            val listaDeGatos = AnimalProvider.animalesList.filter { it.especieAnimal == "Reptil" }
            recyclerView.adapter = AnimalAdapter(listaDeGatos )
        } else {
            recyclerView.adapter = AnimalAdapter(AnimalProvider.animalesList )
        }


    }
}