package com.example.moviles

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_b_list_view.*
import kotlinx.android.synthetic.main.activity_main.*

class BListViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_b_list_view)
        val listaEntrenadores = arrayListOf<Entrenador>()
        listaEntrenadores.add(Entrenador("Karlita","Revelo"))
        listaEntrenadores.add(Entrenador("Paul","Reinoso"))
        listaEntrenadores.add(Entrenador("Andrés","Guachamin"))
        listaEntrenadores.add(Entrenador("Andrea","Silva"))
        listaEntrenadores.add(Entrenador("Cecilia","Herrera"))
        listaEntrenadores.add(Entrenador("Oswaldo","Zambrano"))
        listaEntrenadores.add(Entrenador("Sara","Lopez"))

        val adaptador = ArrayAdapter(
            this, // contexto
            android.R.layout.simple_list_item_1, //nombre layout
            listaEntrenadores // lista
        )

        lv_numeros.adapter = adaptador

        lv_numeros
            .onItemClickListener = AdapterView.OnItemClickListener{
            parent, view, position, id ->
            Log.i("list-view", "Posicion $position")
        }

        bt_anadirEntrenador
            .setOnClickListener {
                anadirEntrenador(
                    adaptador,
                    listaEntrenadores
                )
            }
    }

    fun anadirEntrenador(
        adaptador : ArrayAdapter<Entrenador>,
        listaEntrenadores : ArrayList<Entrenador>
    ){
        listaEntrenadores.add(
            Entrenador("Laura","Gomez")
        )
        adaptador.notifyDataSetChanged()
    }
}