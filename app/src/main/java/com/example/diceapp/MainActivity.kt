package com.example.diceapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast


class Dice(val numSides:Int){
    fun roll():Int{
        return (1..numSides).random()
    }
}

class MainActivity : AppCompatActivity() {
    private fun rollDice(){
        val num = Dice(6).roll()
        findViewById<TextView>(R.id.textView).text = num.toString()
        val toast = Toast.makeText(this,"Rolled!",Toast.LENGTH_SHORT)
        toast.show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        val dice = Dice(6)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btn:Button = findViewById<Button>(R.id.button)
        btn.setOnClickListener {
            val num = dice.roll()
            findViewById<TextView>(R.id.textView).text = num.toString()
            val toast = Toast.makeText(this,"Rolled!",Toast.LENGTH_SHORT)
            toast.show()
        }
    }
}