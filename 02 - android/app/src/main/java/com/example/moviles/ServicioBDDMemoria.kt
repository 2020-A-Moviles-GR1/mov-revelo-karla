package com.example.moviles

class ServicioBDDMemoria {
    companion object { //solo existe una instancia de esta clase
        var numero = 0
        fun anadirNumero() {
            this.numero = this.numero + 1
        }
    }
}