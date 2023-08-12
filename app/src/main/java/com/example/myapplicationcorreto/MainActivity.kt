package com.example.myapplicationcorreto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnCalculate: Button=findViewById(R.id.bntCalculate)
        val edtHeight : EditText = findViewById(R.id.edittext_height)
        val edtMsgWeight : EditText = findViewById(R.id.edittext_weight)

        btnCalculate.setOnClickListener {

            val alturaStr = edtHeight.text.toString()
            val pesoStr = edtMsgWeight.text.toString()

            if(alturaStr.isNotEmpty() && pesoStr.isNotEmpty()) {

                val altura: Float = alturaStr.toFloat()
                val peso: Float = pesoStr.toFloat()

                val alturaFinal: Float = altura * altura
                val result: Float = peso / alturaFinal


                val intent = Intent(this, ResultActivity::class.java)

                    .apply {
                        putExtra("EXTRA_RESULT", result)
                    }

                startActivity(intent)
            }else {
                Toast.makeText(this, "Fill the blank", Toast.LENGTH_LONG).show()
            }


        }




    }
}