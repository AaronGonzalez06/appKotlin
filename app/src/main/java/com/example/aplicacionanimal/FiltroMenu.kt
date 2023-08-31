package com.example.aplicacionanimal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import com.example.aplicacionanimal.databinding.FiltroMenuBinding

class FiltroMenu : AppCompatActivity() {
    private lateinit var binding: FiltroMenuBinding
    private lateinit var listIntent: Intent
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.filtro_menu)
        binding = FiltroMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val boton: Button = binding.btnBuscar

        boton.setOnClickListener { filtro()}
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun filtro() {
        val texto : EditText = binding.etNombre
        val mamifero : CheckBox = binding.cbMamiferos
        val ave : CheckBox = binding.cbAves
        val reptil : CheckBox = binding.cbReptiles
        val cb_1 : CheckBox = binding.cb1
        val cb_2 : CheckBox = binding.cb2
        val cb_3 : CheckBox = binding.cb3
        val cb_4 : CheckBox = binding.cb4
        val cb_5 : CheckBox = binding.cb5

        val datos_a_filtrar = mutableListOf<String>()
        var aux: Boolean = false
        var aux2: Boolean = false
        if(texto.getText().toString() != ""){
            datos_a_filtrar.add(texto.getText().toString())
        }

        if(mamifero.isChecked()){
            datos_a_filtrar.add("Mamifero")
            aux = true
        }

        if(ave.isChecked()){
            datos_a_filtrar.add("ave")
            aux = true
        }

        if(reptil.isChecked()){
            datos_a_filtrar.add("Reptil")
            aux = true
        }

        if(cb_1.isChecked()){
            datos_a_filtrar.add("1")
            aux2 = true
        }

        if(cb_2.isChecked()){
            datos_a_filtrar.add("2")
            aux2 = true
        }

        if(cb_3.isChecked()){
            datos_a_filtrar.add("3")
            aux2 = true
        }

        if(cb_4.isChecked()){
            datos_a_filtrar.add("4")
            aux2 = true
        }

        if(cb_5.isChecked()){
            datos_a_filtrar.add("5")
            aux2 = true
        }

        if((aux) && (aux2)){
            val intent = Intent(this, HorizontalFiltro::class.java)
            val listaInmutable: List<String> = datos_a_filtrar.toList()
            intent.putExtra("datosFiltrar", listaInmutable.toTypedArray())
            startActivity(intent)

        }else{
            Toast.makeText(this, "Selecciona mínimo una especie y un nivel de peligrosidad", Toast.LENGTH_SHORT).show()
        }
        

    }

}