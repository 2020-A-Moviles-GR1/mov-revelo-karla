package com.example.examen1bimestre

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_agregar_ejercicio.*

class AgregarEjercicioActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agregar_ejercicio)

        val posicion= intent.getIntExtra("index",-1)
        val musculo = "oblicuo mayor"

        if(posicion>-1){
            tv_agregar_modificar_c.text="Modificar Ejercicio"
            btn_agregar_modificar.setText("MODIFICAR")
            btn_agregar_musculo.setVisibility(View.GONE)
            var ejercicio:Ejercicio= BddService.recuperarEjercicio(posicion)
            et_nombre.setText(ejercicio.nombre)
            et_duracion.setText(ejercicio.duracion)
            et_repeticiones.setText(ejercicio.repeticiones)
            et_eliminaGrasa.setText(ejercicio.eliminaGrasa)
            btn_agregar_modificar.setOnClickListener {
                BddService.modificarEjercicio(posicion, Ejercicio(
                    et_nombre.text.toString(),
                    et_duracion.text.toString(),
                    et_repeticiones.text.toString(),
                    et_eliminaGrasa.text.toString(),
                    musculo
                ))
                Toast.makeText(applicationContext,"Ejercicio modificado",Toast.LENGTH_SHORT).show()
                irAEjercicio(posicion)
            }

        }else{
            tv_agregar_modificar_c.text="Añadir Ejercicio"
            btn_agregar_modificar.setText("AÑADIR")
            btn_agregar_musculo.setOnClickListener {
                this.startActivity(Intent(this,AgregarMusculoActivity::class.java))}
            btn_agregar_modificar.setOnClickListener {
                BddService.agregarEjercicio(Ejercicio(
                    et_nombre.text.toString(),
                    et_duracion.text.toString(),
                    et_repeticiones.text.toString(),
                    et_eliminaGrasa.text.toString(),
                    musculo
                ))

                Toast.makeText(applicationContext,"Ejercicio añadido",Toast.LENGTH_SHORT).show()
            }
        }
        btn_agregar_a_lista.setOnClickListener {
            this.startActivity(Intent(this,ListaEjerciciosActivity::class.java))
        }
        btn_agregar_a_main.setOnClickListener {
            this.startActivity(Intent(this,MainActivity::class.java))
        }
    }
    fun irAEjercicio(posicion:Int){
        val intentExplicito= Intent(this, EjercicioActivity::class.java)
        intentExplicito.putExtra("index",posicion)
        this.startActivity(intentExplicito)
    }
    fun irAListaEjercicios(){
        val intentExplicito= Intent(this, ListaEjerciciosActivity::class.java)
        this.startActivity(intentExplicito)
    }

}