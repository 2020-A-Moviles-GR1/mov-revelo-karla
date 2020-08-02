package com.example.examen1bimestre

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_lista_ejercicios2.*

class ListaEjerciciosActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_ejercicios2)
        val listaEjercicios= BddServicio.listaEjercicios


        val adaptador=ArrayAdapter(this,android.R.layout.simple_list_item_1,listaEjercicios)
        lv_ejercicios.adapter=adaptador

        lv_ejercicios.onItemClickListener=AdapterView.OnItemClickListener{
                parent,view,position,id ->
            Log.i("list-view","Posicion ${listaEjercicios[position]}")
            irAEjercicio(position);
        }
        btn_lista_a_main.setOnClickListener {
            this.startActivity(Intent(this,MainActivity::class.java))
        }

    }
    fun irAEjercicio(posicion:Int){
        val intentExplicito= Intent(this, EjercicioActivity::class.java)
        intentExplicito.putExtra("index",posicion)
        this.startActivity(intentExplicito)
    }


}