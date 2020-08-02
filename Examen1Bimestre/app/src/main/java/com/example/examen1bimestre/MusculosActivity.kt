package com.example.examen1bimestre

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_musculos.*

class MusculosActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_musculos)
        val posicion= intent.getIntExtra("index",-1)
        val listaMusculos= BddService.listaMusculos1

        val adaptador=ArrayAdapter(this,android.R.layout.simple_list_item_1,listaMusculos)
        lv_musculos.adapter=adaptador

        lv_musculos.onItemClickListener=AdapterView.OnItemClickListener{
                parent,view,position,id ->
            Log.i("list-view","Posicion ${listaMusculos[position]}")
            irAEjercicio(position);
        }
        btn_musculos_a_main.setOnClickListener {
            this.startActivity(Intent(this,MainActivity::class.java))
        }
        btn_musculos_a_lista.setOnClickListener {
            this.startActivity(Intent(this, ListaEjerciciosActivity::class.java))
        }
        tv_ejercicio_y_musculo.setText("Abdominales")

    }
    fun irAEjercicio(posicion:Int){
        val intentExplicito= Intent(this, MusculoCRUDActivity::class.java)
        intentExplicito.putExtra("index",posicion)
        this.startActivity(intentExplicito)
    }

}