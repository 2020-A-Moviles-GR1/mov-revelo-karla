package com.example.examen1bimestre

class Cancion(var nombre:String, var autor:String,var genero:String,var acordes:String) {
    override fun toString(): String {
        return "Nombre Canción: ${nombre} ,Autor/Grupo: ${autor}  "
    }

}