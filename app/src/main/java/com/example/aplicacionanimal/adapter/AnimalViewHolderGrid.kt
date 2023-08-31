package com.example.animales.adapter

import android.content.Context
import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Color
import android.view.View
import android.widget.*
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.aplicacionanimal.R
import com.example.aplicacionanimal.TodoAnimales
import com.example.aplicacionanimal.UnidadLogica
import com.example.aplicacionanimal.databinding.ItemGridBinding
import com.example.aplicacionanimal.modelo.Animal

class AnimalViewHolderGrid(view: View):RecyclerView.ViewHolder(view){

    val binding = ItemGridBinding.bind(view)

    fun render(animalModel: Animal, onClickListener:(Animal) -> Unit){
        binding.tvNombreAnimal.text = animalModel.nombreAnimal
        binding.tvTipoAnimal.text = animalModel.tipoAnimal
        binding.tvEspecieAnimal.text = animalModel.especieAnimal
        binding.ivAnimal.setImageResource(animalModel.imagenAnimal)
        binding.ivAnimal.tag = "imagenOne"
        binding.btnBoton.setOnClickListener {
            if (binding.ivAnimal.tag == "imagenOne") {
                binding.ivAnimal.setImageResource(animalModel.imagenAnimalTwo)
                binding.ivAnimal.tag = "imagenTwo"
            } else {
                binding.ivAnimal.setImageResource(animalModel.imagenAnimal)
                binding.ivAnimal.tag = "imagenOne"
            }
        }
        binding.btnInformacion.setOnClickListener{ onClickListener(animalModel) }
        binding.btnDelete.visibility = View.GONE
    }
}