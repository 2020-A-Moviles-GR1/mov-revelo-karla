package com.example.examen1bimestre

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_lista_canciones.*
import kotlinx.android.synthetic.main.activity_main.*

class ListaCancionesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_canciones)
        val listaCanciones= BddService.listaCanciones


        val adaptador=ArrayAdapter(this,android.R.layout.simple_list_item_1,listaCanciones)
        lv_canciones.adapter=adaptador

        lv_canciones.onItemClickListener=AdapterView.OnItemClickListener{
                parent,view,position,id ->
           Log.i("list-view","Posicion ${listaCanciones[position]}")
            irACancion(position);
        }
        btn_lista_a_main.setOnClickListener {
            this.startActivity(Intent(this,MainActivity::class.java))
        }





    }
    fun irACancion(posicion:Int){
        val intentExplicito= Intent(this, CancionActivity::class.java)
        intentExplicito.putExtra("index",posicion)
        this.startActivity(intentExplicito)
    }


}