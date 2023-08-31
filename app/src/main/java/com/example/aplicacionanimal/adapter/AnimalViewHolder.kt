package com.example.animales.adapter

import android.content.res.ColorStateList
import android.graphics.Color
import android.view.View
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.example.aplicacionanimal.R
import com.example.aplicacionanimal.modelo.Animal

class AnimalViewHolder(view: View):RecyclerView.ViewHolder(view){

    val nombreAnimal = view.findViewById<TextView>(R.id.tvNombreAnimal)
    val tipoAnimal = view.findViewById<TextView>(R.id.tvTipoAnimal)
    val especieAnimal = view.findViewById<TextView>(R.id.tvEspecieAnimal)
    val ratingBar = view.findViewById<RatingBar>(R.id.ratingBar)
    val boton = view.findViewById<Button>(R.id.btnBoton)

    val imagen = view.findViewById<ImageView>(R.id.ivAnimal)

    fun render(animalModel: Animal){
        nombreAnimal.text = animalModel.nombreAnimal
        tipoAnimal.text = animalModel.tipoAnimal
        especieAnimal.text = animalModel.especieAnimal
        imagen.setImageResource(animalModel.imagenAnimal)
        ratingBar.numStars = animalModel.peligrosidad
        ratingBar.rating = animalModel.peligrosidad.toFloat()
        imagen.tag = "imagenOne"
        boton.setOnClickListener {
            if (imagen.tag == "imagenOne") {
                imagen.setImageResource(animalModel.imagenAnimalTwo)
                imagen.tag = "imagenTwo"
            } else {
                imagen.setImageResource(animalModel.imagenAnimal)
                imagen.tag = "imagenOne"
            }
        }

    }
}