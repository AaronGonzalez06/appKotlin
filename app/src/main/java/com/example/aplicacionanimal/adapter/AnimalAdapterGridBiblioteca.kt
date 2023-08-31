package com.example.animales.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.aplicacionanimal.R
import com.example.aplicacionanimal.modelo.Animal

class AnimalAdapterGridBiblioteca(
    private val animalList:List<Animal>,
    private val onClickListener:(Animal) -> Unit,
    private val onClickDelete:(Int) -> Unit
    ) : RecyclerView.Adapter<AnimalViewHolderGridBiblioteca>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimalViewHolderGridBiblioteca {
        val layoutInflater = LayoutInflater.from(parent.context)
        return AnimalViewHolderGridBiblioteca(layoutInflater.inflate(R.layout.item_grid, parent, false))
    }

    override fun getItemCount(): Int = animalList.size

    override fun onBindViewHolder(holder: AnimalViewHolderGridBiblioteca, position: Int) {
        val item = animalList[position]
        holder.render(item, onClickListener, onClickDelete)
    }
}