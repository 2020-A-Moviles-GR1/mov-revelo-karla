package com.example.examen1bimestre

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_acordes.*
import kotlinx.android.synthetic.main.activity_agregar_cancion.*
import kotlinx.android.synthetic.main.activity_cancion.*
import kotlinx.android.synthetic.main.activity_cancion.tv_acordes

class CancionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cancion)
        val posicion= intent.getIntExtra("index",-1)

        if(posicion>-1){
            var cancion:Cancion= BddService.obtenerCancion(posicion)
            tv_nombre.text=cancion.nombre;
            tv_autor.text=cancion.autor;
            tv_genero.text=cancion.genero;
            tv_acordes.text=cancion.acordes;

            btn_eliminar.setOnClickListener {
                BddService.elimarCancion(cancion)
                Toast.makeText(applicationContext,"Cancion Eliminada", Toast.LENGTH_SHORT).show()
                irAListaCanciones()
            }
            btn_modificar.setOnClickListener {
                irACancionAgregar(posicion);
            }
            btn_a_acordeslist.setOnClickListener {
                irAAcordesCancion(posicion)
            }

        }else{
           irAListaCanciones()
        }
        btn_cancion_a_lista.setOnClickListener {
            irAListaCanciones()
        }
        btn_cancion_a_main.setOnClickListener {
            this.startActivity(Intent(this,MainActivity::class.java))
        }

    }
    fun irAListaCanciones(){
        val intentExplicito= Intent(this, ListaCancionesActivity::class.java)
        this.startActivity(intentExplicito)
    }
    fun irACancionAgregar(posicion:Int){
        val intentExplicito= Intent(this, AgregarCancionActivity::class.java)
        intentExplicito.putExtra("index",posicion)
        this.startActivity(intentExplicito)
    }
    fun irAAcordesCancion(posicion:Int){
        val intentExplicito= Intent(this, AcordesActivity::class.java)
        intentExplicito.putExtra("index",posicion)
        this.startActivity(intentExplicito)
    }
}