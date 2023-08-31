package com.example.aplicacionanimal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.animales.adapter.AnimalAdapter
import com.example.aplicacionanimal.data.AnimalProvider
import com.example.aplicacionanimal.modelo.Animal

class HorizontalFiltro : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.filtro_vista)
        initRecyclerView()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun initRecyclerView() {
        val recyclerView = findViewById<RecyclerView>(R.id.vertical_recycler_view)
        val valorDado = intent.getStringArrayExtra("datosFiltrar")
        val listaMutable = valorDado?.toMutableList() ?: mutableListOf()
        var tipoRecibido: TextView = findViewById(R.id.tvtipo)
        var peligroRecibido: TextView = findViewById(R.id.tvpeligro)
        var totalResultado : TextView = findViewById(R.id.tvtotalresultados)
        var listado : MutableList<Animal> = mutableListOf()
        var listadoTwo : MutableList<Animal> = mutableListOf()
        var listadoTree : MutableList<Animal> = mutableListOf()
        for (elemento in listaMutable) {
            if (elemento == "Mamifero") {
                listadoTwo.addAll(AnimalProvider.animalesList.filter { it.especieAnimal == "Mamifero" })
                tipoRecibido.append(" Mamifero")
            } else if (elemento == "ave"){
                listadoTwo.addAll(AnimalProvider.animalesList.filter { it.especieAnimal == "ave" })
                tipoRecibido.append(" Ave")
            } else if (elemento == "Reptil"){
                listadoTwo.addAll(AnimalProvider.animalesList.filter { it.especieAnimal == "Reptil" })
                tipoRecibido.append(" Reptil")
            } else {
                listadoTwo.addAll(AnimalProvider.animalesList.filter { it.nombreAnimal.contains(elemento) })
            }
        }
        println("primer filtro" + listadoTwo)
        for (elemento in listaMutable) {
            if (elemento == "1"){
                listadoTree.addAll(listadoTwo.filter { it.peligrosidad == 1 })
                peligroRecibido.append(" Nivel 1")
            } else if (elemento == "2"){
                listadoTree.addAll(listadoTwo.filter { it.peligrosidad == 2 })
                peligroRecibido.append(" Nivel 2")
            } else if (elemento == "3"){
                listadoTree.addAll(listadoTwo.filter { it.peligrosidad == 3 })
                peligroRecibido.append(" Nivel 3")
            } else if (elemento == "4"){
                listadoTree.addAll(listadoTwo.filter { it.peligrosidad == 4 })
                peligroRecibido.append(" Nivel 4")
            } else if (elemento == "5"){
                listadoTree.addAll(listadoTwo.filter { it.peligrosidad == 5 })
                peligroRecibido.append(" Nivel 5")
            }
        }
        println("segundo filtro" + listadoTree)

        if(listadoTree.isEmpty()){
            totalResultado.append(" 0")
            Toast.makeText(this, "Sin Resultados en la búsqueda", Toast.LENGTH_LONG).show()
        }else{
            totalResultado.append(" " +listadoTree.size )
            recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
            recyclerView.adapter = AnimalAdapter(listadoTree)
        }
    }
}