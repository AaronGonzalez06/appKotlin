package com.example.aplicacionanimal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import com.example.aplicacionanimal.data.AnimalProvider

class UnidadLogica : AppCompatActivity() {
    private lateinit var listIntent: Intent
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.info_main)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val valorDado = intent.getStringExtra("filtroValor")
        val animal = AnimalProvider.animalesList.filter { it.idAnimal.toString() == valorDado }
        if (animal != null) {

            val titulo:TextView = findViewById(R.id.tvNombreAnimal)
            titulo.text = animal[0].nombreAnimal
            val info:TextView = findViewById(R.id.instituto)
            info.text = animal[0].informacion
            //imagenes
            val img1 : ImageView = findViewById(R.id.ivAnimal)
            img1.setImageResource(animal[0].imagenAnimal)
            val img2 : ImageView = findViewById(R.id.ivAnimalTwo)
            img2.setImageResource(animal[0].imagenAnimalTwo)
            //informacionGeneral
            val textDerecha: TextView = findViewById(R.id.tvDerecho)
            val textIzquierda: TextView = findViewById(R.id.tvIzquierdo)
            textDerecha.text = animal[0].especieAnimal
            textIzquierda.text = animal[0].tipoAnimal

            val boton:Button = findViewById(R.id.btnMenu)
            boton.setOnClickListener {
                listIntent = Intent(this, MenuLogica::class.java)
                startActivity(listIntent)
            }

            val ratingBar : RatingBar = findViewById(R.id.ratingBar)
            ratingBar.numStars = animal[0].peligrosidad
            ratingBar.rating = animal[0].peligrosidad.toFloat()

        } else {
            Log.d("MiApp", "No se encontró ningún animal con el ID $valorDado")
        }
    }


}