package com.example.geoquiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class PermissionActivity : AppCompatActivity() {

    var pregunta = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_permission)

        setupView()
    }

    fun setupView(){
        var cuestionario = findViewById<TextView>(R.id.tvCuestionario)
        var pelicula = findViewById<Button>(R.id.btpelicula)
        var equipo = findViewById<Button>(R.id.btEquipo)
        var capital = findViewById<Button>(R.id.btCapitales)

        capital.setOnClickListener {
            pregunta = "CAPITAL"
            var intent = Intent(this,MainActivity::class.java).apply {
                putExtra("PREGUNTA",pregunta)
            }
            startActivity(intent)
        }

        pelicula.setOnClickListener {
            pregunta = "PELICULA"
            var intent = Intent(this,MainActivity::class.java).apply {
                putExtra("PREGUNTA",pregunta)
            }
            startActivity(intent)
        }

        equipo.setOnClickListener {
            pregunta = "EQUIPO"
            var intent = Intent(this,MainActivity::class.java).apply {
                putExtra("PREGUNTA",pregunta)
            }
            startActivity(intent)
        }
    }
}