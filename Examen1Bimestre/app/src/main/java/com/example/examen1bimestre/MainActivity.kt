package com.example.examen1bimestre

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_agregar_ejercicio.setOnClickListener {
            this.startActivity(Intent(this, AgregarEjercicioActivity::class.java))
        }
        btn_listar_ejercicios.setOnClickListener {
            this.startActivity(Intent(this, ListaEjerciciosActivity::class.java))
        }

    }

}