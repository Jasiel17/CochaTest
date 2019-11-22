package io.github.n0g4y0.cochatest

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var botonVerdad : Button
    private lateinit var botonFalso : Button
    private lateinit var botonAdelante : Button
    private lateinit var botonAtras : Button
    private lateinit var texto : TextView
    private var indiceActual = 0

    private val bancoPreguntas = listOf(
        Pregunta(R.string.question_1, false),
        Pregunta(R.string.question_2,false),
        Pregunta(R.string.question_3,true),
        Pregunta(R.string.question_4,false),
        Pregunta(R.string.question_5,true),
        Pregunta(R.string.question_6,false),
        Pregunta(R.string.question_7,true),
        Pregunta(R.string.question_8,false)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        botonVerdad = findViewById(R.id.verdad_button)
        botonFalso = findViewById(R.id.falso_button)
        botonAdelante = findViewById(R.id.adelante_button)
        botonAtras = findViewById(R.id.atras_button)
        texto= findViewById(R.id.pregunta_text)

        botonVerdad.setOnClickListener {view : View ->
            verificarRespuesta(true)
        }

        botonFalso.setOnClickListener {view : View ->

            verificarRespuesta(false)
        }

        botonAdelante.setOnClickListener {
            cicloPreguntasAdelante(indiceActual)
        }

        botonAtras.setOnClickListener {
            cicloPreguntasAtras(indiceActual)
        }
        actualizarPregunta()
    }

    private fun actualizarPregunta(){

        val textoPreguntaID = bancoPreguntas[indiceActual].idTexto
        pregunta_text.setText(textoPreguntaID)

    }

    private fun actualizarPregunta1(ind: Int){

        val textoPreguntaID = bancoPreguntas[ind].idTexto
        texto.setText(textoPreguntaID)

    }
    private fun verificarRespuesta(respuestaUsuario: Boolean){

            val respuestaCorrecta = bancoPreguntas[indiceActual].respuesta
            val mostrarMensajeID =  if (respuestaUsuario == respuestaCorrecta){
                "Correcto"
            } else {
                "Incorrecto"
            }
            Toast.makeText(this,mostrarMensajeID,Toast.LENGTH_SHORT).show()

    }

    private fun cicloPreguntasAtras(ind: Int){
        if(indiceActual==0){
            indiceActual = bancoPreguntas.size -1
            actualizarPregunta1(indiceActual)
        }else{
            indiceActual = indiceActual - 1
            actualizarPregunta1(indiceActual)
        }
    }

    private fun cicloPreguntasAdelante(ind: Int){
        if(indiceActual+1 == bancoPreguntas.size ){
            indiceActual = 0
            actualizarPregunta1(indiceActual)
        }else{
            indiceActual = indiceActual + 1
            actualizarPregunta1(indiceActual)
        }
    }

}
