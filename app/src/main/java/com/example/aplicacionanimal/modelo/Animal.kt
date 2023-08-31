package com.example.aplicacionanimal.modelo

import android.graphics.drawable.Drawable
import androidx.annotation.DrawableRes

data class Animal (
    val nombreAnimal:String,
    val especieAnimal:String,
    val tipoAnimal:String,
    val peligrosidad:Int,
    @DrawableRes val imagenAnimal: Int,
    @DrawableRes val imagenAnimalTwo: Int,
    val idAnimal: Int,
    val informacion: String
    ){
}