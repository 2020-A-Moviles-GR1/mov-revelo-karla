package com.example.examen1bimestre

class Acorde(var notacionInglesa:String, var notacionLatina:String, var imagen: Int) {
    override fun toString(): String {
        return "Acorde: ${notacionInglesa} ,imagen: ${imagen}  "
    }

}