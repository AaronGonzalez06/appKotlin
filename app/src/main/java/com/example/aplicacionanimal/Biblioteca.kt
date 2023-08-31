package com.example.aplicacionanimal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.animales.adapter.AnimalAdapterGridBiblioteca
import com.example.aplicacionanimal.data.AnimalProvider
import com.example.aplicacionanimal.databinding.BibliotecaMainBinding
import com.example.aplicacionanimal.modelo.Animal

class Biblioteca : AppCompatActivity() {

    private lateinit var binding: BibliotecaMainBinding
    private var animalMutableList: MutableList<Animal> = AnimalProvider.animalesList.shuffled().take(6).toMutableList()
    private lateinit var adapter: AnimalAdapterGridBiblioteca

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = BibliotecaMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecyclerView()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

    }

    private fun initRecyclerView() {
        adapter = AnimalAdapterGridBiblioteca(
            animalList = animalMutableList,
        onClickListener = { animal -> prueba(animal) },
        onClickDelete = { position -> onDeleteItem(position)})
        binding.recyclerAnimal.layoutManager = GridLayoutManager(this,2)
        binding.recyclerAnimal.adapter = adapter
    }

    private fun onDeleteItem(position:Int){
        animalMutableList.removeAt(position)
        adapter.notifyItemRemoved(position)
    }

    private fun prueba(animal: Animal){
        //Toast.makeText(this,animal.idAnimal.toString(), Toast.LENGTH_SHORT).show()
        val intent = Intent(this, UnidadLogica::class.java)
        val valor = animal.idAnimal.toString()
        intent.putExtra("filtroValor", valor)
        startActivity(intent)
    }
}