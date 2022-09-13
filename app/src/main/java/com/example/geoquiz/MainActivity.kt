package com.example.geoquiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var questions: ArrayList<Question>
    var posicion = 0
    var score = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val pregunta = intent.getStringExtra("PREGUNTA").toString()

        loadQuestions(pregunta)
        setupViews()
    }

    private fun loadQuestions(pregunta: String){
        if(pregunta == "CAPITAL"){
            loadQuestionsCapitales()
        }
        if(pregunta == "EQUIPO"){
            loadQuestionsEquipo()
        }
        if(pregunta == "PELICULA"){
            loadQuestionsPelicula()
        }
    }

    private fun loadQuestionsCapitales(){
        questions = ArrayList()

        var question = Question("¿Es Lima la capital de Peru?", true)
        questions.add(question)

        questions.add(Question("¿Es Lima la capital de Chile?",false))
        questions.add(Question("¿Es La Paz la capital de Chile?",false))
        questions.add(Question("¿Es Lima la capital de Bolivia?",false))
        questions.add(Question("¿Es Lima la capital de Chile?",false))
        questions.add(Question("¿Es Brazil capital de Venezuela?",false))
        questions.add(Question("¿Es Quito capital de Ecuador?",true))
        questions.add(Question("¿Es Quito la capital de Lima?",false))
    }

    private fun loadQuestionsEquipo(){
        questions = ArrayList()

        var question = Question("¿Real Madrid es el ultimo campeón de la Champions?", true)
        questions.add(question)
        questions.add(Question("¿Manchester City ha ganado dos veces la Champions?",false))
        questions.add(Question("¿Varsil es el ultimo campeon de la copa america?",false))
        questions.add(Question("¿Redmayne es el arquero mas odiado?",true))
        questions.add(Question("¿Diego Maladroga gano un mundial?",true))
        questions.add(Question("¿CR7 es mejor que Messi?",false))
        questions.add(Question("¿Guerrero seguira en la seleccion?",true))
        questions.add(Question("¿Perú ira al mundial tras la difucion del audio de Byron Castillo?",true))
    }

    private fun loadQuestionsPelicula(){
        questions = ArrayList()

        var question = Question("¿Has visto Interestellar?", true)
        questions.add(question)
        questions.add(Question("¿Has visto 1000 to 1?",false))
        questions.add(Question("¿Has visto TerraVision?",true))
        questions.add(Question("¿En The Martian, Brad Pitt es el personaje principal?",false))
        questions.add(Question("¿Matt Damon es el personaje principal en En busca del Destino?",true))
        questions.add(Question("¿Russell Crowe gano el premio Oscar?",true))
        questions.add(Question("¿Robert Downey Jr. conocio Elon Musk?",true))
        questions.add(Question("¿Emma Stone gano el premio Oscar?",true))
    }

    private fun setupViews() {
        val tvQuestion = findViewById<TextView>(R.id.tvQuestion)
        val btYes = findViewById<Button>(R.id.btYes)
        val btNo = findViewById<Button>(R.id.btNo)
        val btNext = findViewById<Button>(R.id.btNext)
        val txtScore = findViewById<TextView>(R.id.txtScore)
        val btInicio = findViewById<Button>(R.id.btInicio)

        tvQuestion.text = questions[posicion].sentence
        btInicio.setEnabled(false)

        btYes.setOnClickListener {
            if(questions[posicion].answer == true) {
                Toast.makeText(this, "Correcto", Toast.LENGTH_LONG).show()
                txtScore.text = setScore().toString()
            }
            else{
                Toast.makeText(this, "Incorrecto", Toast.LENGTH_LONG).show()

            }
            btYes.setEnabled(false)
            btNo.setEnabled(false)
            btNext.setEnabled(true)
        }

        btNo.setOnClickListener {
            if(questions[posicion].answer == false) {
                Toast.makeText(this, "Correcto", Toast.LENGTH_LONG).show()
                txtScore.text = setScore().toString()
            }
            else{
                Toast.makeText(this,"Incorrecto",Toast.LENGTH_LONG).show()
            }
            btYes.setEnabled(false)
            btNo.setEnabled(false)
            btNext.setEnabled(true)
        }

        btNext.setOnClickListener {
            btYes.setEnabled(true)
            btNo.setEnabled(true)
            if(posicion<questions.size-1){
                posicion++
                tvQuestion.text = questions[posicion].sentence
                }
            else{
                Toast.makeText(this, "Limite Superado", Toast.LENGTH_SHORT).show()
                btInicio.setEnabled(true)
            }
            btNext.setEnabled(false)
        }

        btInicio.setOnClickListener {
            var intent = Intent(this,PermissionActivity::class.java)
            startActivity(intent)
        }
    }

    fun setScore(): Int{
        score = score + 50
        return score
    }

}