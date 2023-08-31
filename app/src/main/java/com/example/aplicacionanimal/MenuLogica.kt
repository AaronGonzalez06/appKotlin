package com.example.aplicacionanimal

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.aplicacionanimal.databinding.MenuactivityBinding

class MenuLogica : AppCompatActivity() {
    private lateinit var binding: MenuactivityBinding
    private lateinit var listIntent: Intent
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.menuactivity)
        binding = MenuactivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val boton: Button = binding.boton
        val boton2: Button = binding.boton2
        val boton3: Button = binding.boton3
        val boton4: Button = binding.boton4
        val boton5: Button = binding.boton5
        val boton6: Button = binding.boton6
        val boton7: Button = binding.boton7
        val boton8: Button = binding.boton8
        boton.setOnClickListener { ver_todo() }
        boton2.setOnClickListener { ver_reptiles() }
        boton3.setOnClickListener { ver_mamiferos() }
        boton4.setOnClickListener { ver_aves() }
        boton6.setOnClickListener { emergencias() }
        boton5.setOnClickListener { filtro_menu() }
        boton7.setOnClickListener { biblioteca() }
        boton8.setOnClickListener { finishAffinity() }
    }

    private fun biblioteca() {
        listIntent = Intent(this, Biblioteca::class.java)
        startActivity(listIntent)
    }

    private fun filtro_menu() {
        listIntent = Intent(this, FiltroMenu::class.java)
        startActivity(listIntent)
    }

    private fun emergencias() {
        val intent = Intent(Intent.ACTION_DIAL)
        intent.data = Uri.parse("tel:555")
        startActivity(intent)
    }

    private fun ver_todo() {
        val intent = Intent(this, GridLogica::class.java)
        startActivity(intent)
    }

    private fun ver_mamiferos() {
        val intent = Intent(this, TodoAnimales::class.java)
        val valor = "Mamifero"
        intent.putExtra("filtroValor", valor)
        startActivity(intent)
    }

    private fun ver_aves() {
        val intent = Intent(this, TodoAnimales::class.java)
        val valor = "ave"
        intent.putExtra("filtroValor", valor)
        startActivity(intent)
    }

    private fun ver_reptiles() {
        val intent = Intent(this, TodoAnimales::class.java)
        val valor = "Reptil"
        intent.putExtra("filtroValor", valor)
        startActivity(intent)
    }
}