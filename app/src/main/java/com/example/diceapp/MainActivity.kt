package com.example.diceapp

import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text


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
            val text:TextView = findViewById<TextView>(R.id.textView)
            text.text = num.toString()
            val image:ImageView = findViewById<ImageView>(R.id.imageView)
            when (text.text){
                "1" -> image.setImageResource(R.drawable.dice_1)
                "2" -> image.setImageResource(R.drawable.dice_2)
                "3" -> image.setImageResource(R.drawable.dice_3)
                "4" -> image.setImageResource(R.drawable.dice_4)
                "5" -> image.setImageResource(R.drawable.dice_5)
                "6" -> image.setImageResource(R.drawable.dice_6)
            }
        }
    }


}