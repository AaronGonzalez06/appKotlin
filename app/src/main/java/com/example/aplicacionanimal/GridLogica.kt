package com.example.aplicacionanimal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.animales.adapter.AnimalAdapterGrid
import com.example.aplicacionanimal.data.AnimalProvider
import com.example.aplicacionanimal.databinding.GridMainBinding
import com.example.aplicacionanimal.modelo.Animal

class GridLogica : AppCompatActivity() {

    private lateinit var binding: GridMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = GridMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecyclerView()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun initRecyclerView() {
        binding.verticalRecyclerView.layoutManager = GridLayoutManager(this,2)
        binding.verticalRecyclerView.adapter = AnimalAdapterGrid(AnimalProvider.animalesList) { animal ->
            prueba(
                animal
            )
        }
    }

    fun prueba(animal: Animal){
        //Toast.makeText(this,animal.idAnimal.toString(), Toast.LENGTH_SHORT).show()
        val intent = Intent(this, UnidadLogica::class.java)
        val valor = animal.idAnimal.toString()
        intent.putExtra("filtroValor", valor)
        startActivity(intent)
    }
}