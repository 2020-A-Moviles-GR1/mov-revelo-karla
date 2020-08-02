package com.example.examen1bimestre

class Ejercicio(var nombre:String, var duracion:String, var repeticiones:String, var eliminaGrasa:String, var musculo :String) {
    override fun toString(): String {
        return "Ejercicio: ${nombre} , Duracion: ${duracion}, Repeticiones: ${repeticiones}, Musculo: ${musculo}"
    }

}