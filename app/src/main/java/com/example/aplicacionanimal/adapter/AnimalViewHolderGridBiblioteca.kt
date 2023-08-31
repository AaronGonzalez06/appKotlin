package com.example.animales.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.aplicacionanimal.databinding.ItemGridBinding
import com.example.aplicacionanimal.modelo.Animal

class AnimalViewHolderGridBiblioteca(view: View):RecyclerView.ViewHolder(view){

    val binding = ItemGridBinding.bind(view)

    fun render(animalModel: Animal, onClickListener: (Animal) -> Unit, onClickDelete: (Int) -> Unit){
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
        binding.btnDelete.setOnClickListener{ onClickDelete(adapterPosition)}
    }
}