package com.example.moviles

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_intent_envia_parametros.*

class IntentEnviaParametros : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent_envia_parametros)
        // Propiedad de la clase

        val numeroEncontrado = intent.getIntExtra(
           "numero", 0
        )
        if(numeroEncontrado != 0){
            Log.i("intents", "El número encontrado es: ${numeroEncontrado}")
        }

        val textoCompartido: String? = intent.getStringExtra(Intent.EXTRA_TEXT)

        if (textoCompartido != null){
            Log.i("intents", "El texto es: ${textoCompartido}")
        }

        btn_devolver_respuesta
            .setOnClickListener{
                // Método clase
                finish()
            }
    }
}
