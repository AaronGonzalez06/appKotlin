package com.example.animales.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.aplicacionanimal.R
import com.example.aplicacionanimal.modelo.Animal

class AnimalAdapterGrid(private val animalList:List<Animal>, private val onClickListener:(Animal) -> Unit) : RecyclerView.Adapter<AnimalViewHolderGrid>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimalViewHolderGrid {
        val layoutInflater = LayoutInflater.from(parent.context)
        return AnimalViewHolderGrid(layoutInflater.inflate(R.layout.item_grid, parent, false))
    }

    override fun getItemCount(): Int = animalList.size

    override fun onBindViewHolder(holder: AnimalViewHolderGrid, position: Int) {
        val item = animalList[position]
        holder.render(item, onClickListener)
    }
}