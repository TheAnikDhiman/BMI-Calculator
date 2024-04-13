package com.example.bmicalculator_ad

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val calc = findViewById<Button>(R.id.calculate)
        val wt= findViewById<EditText>(R.id.weight)
        val ht_in= findViewById<EditText>(R.id.height_in)
        val ht_ft= findViewById<EditText>(R.id.height_ft)
        val your_health= findViewById<TextView>(R.id.health)

        calc.setOnClickListener {
            if (wt.text.toString()!=" " && ht_ft.text.toString() != " " && ht_in.text.toString() != " "){
                val wt1 = wt.text.toString().toDouble()
                val htin = ht_in.text.toString().toDouble()
                val htft = ht_ft.text.toString().toDouble()

                val totalinch=(htft*12)+htin
                val total_height=(totalinch*2.54)/100

                val BMI= wt1/(total_height*total_height)

                val title = findViewById<TextView>(R.id.title)
                title.text = "Your BMI is ${BMI.toInt()}"
                if (BMI>25){
                    Toast.makeText(applicationContext,"You are OverWeight",Toast.LENGTH_LONG).show()
                    your_health.text="You are Overweight"
                    your_health.setBackgroundColor(resources.getColor(R.color.red))

                }else if(BMI<18){
                    Toast.makeText(applicationContext,"You are UnderWeight",Toast.LENGTH_LONG).show()
                    your_health.text="You are Underweight"
                    your_health.setBackgroundColor(resources.getColor(R.color.blue))

                }else{
                    Toast.makeText(applicationContext,"You are healthy",Toast.LENGTH_LONG).show()
                    your_health.text="You are Healthy"
                    your_health.setBackgroundColor(resources.getColor(R.color.green))
                }
            }
        }
        }
    }