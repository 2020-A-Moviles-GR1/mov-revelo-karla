package com.example.examen1bimestre

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_agregar_musculo.*

class AgregarMusculoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agregar_musculo)

        val posicion = intent.getIntExtra("index", -1)

        if (posicion > -1) {
            tv_agregar_modificar_c.text = "Modificar Músculo"
            btn_agregar_modificar.setText("MODIFICAR")
            var musculo: Musculo = BddServicio.recuperarMusculo(posicion)
            et_nombre_musculo.setText(musculo.nombre)
            et_ubicacion_musculo.setText(musculo.ubicacion)
            et_masa_muscular.setText(musculo.masaMuscular)
            et_definicion.setText(musculo.definicion)
            btn_agregar_modificar.setOnClickListener {
                BddServicio.modificarMusculo(
                    posicion, Musculo(
                        et_nombre_musculo.text.toString(),
                        et_ubicacion_musculo.text.toString(),
                        et_masa_muscular.text.toString(),
                        et_definicion.text.toString()
                    )
                )
                Toast.makeText(applicationContext, "Musculo modificado", Toast.LENGTH_SHORT).show()
                irAMusculo(posicion)
            }

        } else {
            tv_agregar_modificar_c.text = "Añadir Músculo"
            btn_agregar_modificar.setText("AÑADIR")
            btn_agregar_modificar.setOnClickListener {
                BddServicio.agregarMusculo(
                    Musculo(
                        et_nombre_musculo.text.toString(),
                        et_ubicacion_musculo.text.toString(),
                        et_masa_muscular.text.toString(),
                        et_definicion.text.toString()
                    )
                )
                Toast.makeText(applicationContext, "Músculo añadido", Toast.LENGTH_SHORT).show()
                irAListaMusculos()
            }
        }
        btn_agregar_a_lista.setOnClickListener {
            this.startActivity(Intent(this, MusculosActivity::class.java))
        }
        btn_agregar_a_main.setOnClickListener {
            this.startActivity(Intent(this, MainActivity::class.java))
        }
    }

    fun irAMusculo(posicion: Int) {
        val intentExplicito = Intent(this, MusculoCRUDActivity::class.java)
        intentExplicito.putExtra("index", posicion)
        this.startActivity(intentExplicito)
    }

    fun irAListaMusculos() {
        val intentExplicito = Intent(this, MusculosActivity::class.java)
        this.startActivity(intentExplicito)
    }
}
