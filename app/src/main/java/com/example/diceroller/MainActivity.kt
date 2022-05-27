package com.example.diceroller

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.core.text.isDigitsOnly

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.roll_button).setOnClickListener { rollDice() }
        findViewById<Button>(R.id.count_up_button).setOnClickListener { countUp() }
        findViewById<Button>(R.id.reset_button).setOnClickListener { resetCount() }
    }

    private fun rollDice() {
        Toast.makeText(this, "Roll Dice button clicked!", Toast.LENGTH_SHORT).show()
        findViewById<TextView>(R.id.result_text).text = (1..6).random().toString()
    }

    private fun countUp() {
        Toast.makeText(this, "Count Up button clicked!", Toast.LENGTH_SHORT).show()
        findViewById<TextView>(R.id.result_text).apply {
            text = when {
                text.isDigitsOnly() -> {
                    if (text.toString().toInt() < 6) (text.toString().toInt() + 1).toString()
                    else text
                }
                else -> "1"
            }
        }
    }

    private fun resetCount() {
        Toast.makeText(this, "Reset button clicked!", Toast.LENGTH_SHORT).show()
        findViewById<TextView>(R.id.result_text).apply {
            text = if (text.isDigitsOnly()) "0" else text
        }
    }
}