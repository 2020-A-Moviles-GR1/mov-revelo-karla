package com.example.examen1bimestre

class Musculo(var nombre:String, var ubicacion:String, var masaMuscular: String, var definicion: String) {
    override fun toString(): String {
        return "Musculo: ${nombre} ,Ubicacion: ${ubicacion}, Masa muscular: ${masaMuscular}, Definición: ${definicion}  "
    }

}