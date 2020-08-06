package com.example.moviles

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_ciclo_vida
            .setOnClickListener { boton ->
                // this.irCicloDeVida()
                irCicloDeVida()
            }
        btn_list_view
            .setOnClickListener { boton ->
                // this.irCicloDeVida()
                irListView()
            }
        btn_intent_respuesta
            .setOnClickListener { boton ->
                irAIntentConRespuesta()
            }

        btn_intent_implicito
            .setOnClickListener { boton ->
                enviarIntentConRespuesta()
            }

        btn_resp_propia
            .setOnClickListener{boton ->
                enviarIntentConRespuestaPropia()
            }

    }

    fun enviarIntentConRespuestaPropia() {
        val intentExplicito = Intent(
            this,
            IntentEnviaParametros::class.java
        )
        // this.startActivityForResult(intent, codigo de respuesta)
        //5 es un numero elegido, no es especial
        startActivityForResult(intentExplicito, 305)
    }

    fun enviarIntentConRespuesta() {
        val intentConRespuesta = Intent(
            Intent.ACTION_PICK,
            ContactsContract.CommonDataKinds.Phone.CONTENT_URI
        )
        // this.startActivityForResult(intent, codigo de respuesta)
        // 304 es un numero elegido, no es especial
        startActivityForResult(intentConRespuesta, 304)
    }

    override fun onActivityResult(
        requestCode: Int,
        resultCode: Int,
        data: Intent?
    ) {
        super.onActivityResult(requestCode, resultCode, data)
        when (resultCode) {
            RESULT_OK -> {
                Log.i("resultado", "OK")
                // Para obtener el numero de un contacto seleccionado
                when (requestCode) {
                    304 -> { // Contactos
                        val uri = data?.data
                        if (uri != null) {
                            val cursor = contentResolver.query(
                                uri,
                                null,
                                null,
                                null,
                                null,
                                null
                            )
                            cursor?.moveToFirst()
                            val indiceTelefono = cursor?.getColumnIndex(
                                ContactsContract.CommonDataKinds.Phone.NUMBER
                            )
                            val telefono = cursor?.getString(indiceTelefono!!)
                            cursor?.close()
                            Log.i("resultado", "Telefono: ${telefono}")
                        }

                    }
                    305 -> {
                        if (data != null){
                            val nombre = data.getStringExtra("nombre")
                            val edad = data.getIntExtra("edad", 0)
                            Log.i("resultado", "Nombre ${nombre} Edad: ${edad}")
                        }
                    }

                }
            }

            RESULT_CANCELED -> {
                Log.i("resultado", "=(")
            }
        }
    }
        fun irAIntentConRespuesta() {
            val intentExplicito = Intent(
                this,
                IntentEnviaParametros::class.java
            )

            val karlita = Usuario(
                "Karlita",
                31,
                Date(),
                1.0
            )

            val maty = Mascota(
                "Maty",
                karlita
            )

            val arregloMascotas = arrayListOf<Mascota>(maty)

            intentExplicito.putExtra("maty", maty)
            intentExplicito.putExtra("arregloMascotas", arregloMascotas)

            startActivity(intentExplicito)
        }

        fun irCicloDeVida() {
            val intentExplicito = Intent(
                this,
                CicloVida::class.java
            )
            //this.startActivity(intentExplicito)
            startActivity(intentExplicito)
        }

        fun irListView() {
            val intentExplicito = Intent(
                this,
                BListViewActivity::class.java
            )
            startActivity(intentExplicito)
        }
}