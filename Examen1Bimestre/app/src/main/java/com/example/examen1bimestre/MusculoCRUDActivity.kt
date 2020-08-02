package com.example.examen1bimestre

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_musculo_crud.*

class MusculoCRUDActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_musculo_crud)
        val posicion= intent.getIntExtra("index",-1)

        if(posicion>-1){
            var musculo:Musculo= BddServicio.recuperarMusculo(posicion)
            tv_nombre_musculo.text=musculo.nombre;
            tv_ubicacion.text=musculo.ubicacion;
            tv_masaM.text=musculo.masaMuscular;
            tv_definicion.text=musculo.definicion;

            btn_eliminar_musculo.setOnClickListener {
                BddServicio.eliminarMusculo(musculo)
                Toast.makeText(applicationContext,"Músculo eliminado", Toast.LENGTH_SHORT).show()
                irAListMusculos()
            }
            btn_modificar_musculo.setOnClickListener {
                irAAñadirMusculo(posicion);
            }

        }else{
            irAListMusculos()
        }
        btn_musculo_a_lista.setOnClickListener {
            irAListMusculos()
        }
        btn_ejercicio_a_main1.setOnClickListener {
            this.startActivity(Intent(this,MainActivity::class.java))
        }

    }
    fun irAListMusculos(){
        val intentExplicito= Intent(this, MusculosActivity::class.java)
        this.startActivity(intentExplicito)
    }
    fun irAAñadirMusculo(posicion:Int){
        val intentExplicito= Intent(this, AgregarMusculoActivity::class.java)
        intentExplicito.putExtra("index",posicion)
        this.startActivity(intentExplicito)
    }
    }

