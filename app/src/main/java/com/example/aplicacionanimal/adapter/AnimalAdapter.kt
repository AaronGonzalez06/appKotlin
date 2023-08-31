package com.example.animales.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.aplicacionanimal.R
import com.example.aplicacionanimal.modelo.Animal

class AnimalAdapter(private val animalList:List<Animal>) : RecyclerView.Adapter<AnimalViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimalViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return AnimalViewHolder(layoutInflater.inflate(R.layout.item_animal, parent, false))
    }

    override fun getItemCount(): Int = animalList.size

    override fun onBindViewHolder(holder: AnimalViewHolder, position: Int) {
        val item = animalList[position]
        holder.render(item)
    }
}