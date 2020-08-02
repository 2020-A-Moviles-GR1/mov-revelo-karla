package com.example.examen1bimestre

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_ejercicio.*
import kotlinx.android.synthetic.main.activity_ejercicio.tv_musculos

class EjercicioActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejercicio)
        val posicion= intent.getIntExtra("index",-1)
        val musculo = "gluteo mayor"

        if(posicion>-1){
            var ejercicio:Ejercicio= BddServicio.recuperarEjercicio(posicion)
            tv_nombre.text=ejercicio.nombre;
            tv_duracion.text=ejercicio.duracion;
            tv_repeticiones.text=ejercicio.repeticiones;
            tv_eliminaGrasa.text=ejercicio.eliminaGrasa;
            tv_musculos.text = ejercicio.musculo;

            btn_eliminar.setOnClickListener {
                BddServicio.eliminarEjercicio(ejercicio)
                Toast.makeText(applicationContext,"Ejercicio eliminado", Toast.LENGTH_SHORT).show()
                irAListaEjercicios()
            }
            btn_modificar.setOnClickListener {
                irAAñadirEjercicio(posicion);
            }
            btn_musculoslist.setOnClickListener {
                irAMusculosEjercicios(posicion)
            }

        }else{
           irAListaEjercicios()
        }
        btn_ejercicio_a_lista.setOnClickListener {
            irAListaEjercicios()
        }
        btn_ejercicio_a_main.setOnClickListener {
            this.startActivity(Intent(this,MainActivity::class.java))
        }

    }
    fun irAListaEjercicios(){
        val intentExplicito= Intent(this, ListaEjerciciosActivity::class.java)
        this.startActivity(intentExplicito)
    }
    fun irAAñadirEjercicio(posicion:Int){
        val intentExplicito= Intent(this, AgregarEjercicioActivity::class.java)
        intentExplicito.putExtra("index",posicion)
        this.startActivity(intentExplicito)
    }
    fun irAMusculosEjercicios(posicion:Int){
        val intentExplicito= Intent(this, MusculosActivity::class.java)
        intentExplicito.putExtra("index",posicion)
        this.startActivity(intentExplicito)
    }
}