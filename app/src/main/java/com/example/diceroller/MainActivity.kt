package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var dice1Image: ImageView
    private lateinit var dice2Image: ImageView
    private lateinit var toast: Toast

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        dice1Image = findViewById(R.id.dice1_image)
        dice2Image = findViewById(R.id.dice2_image)
        findViewById<Button>(R.id.roll_button).setOnClickListener { displayToast(it); rollDice(dice1Image); rollDice(dice2Image) }
        findViewById<Button>(R.id.clear_button).setOnClickListener { displayToast(it); clearDice(dice1Image); clearDice(dice2Image) }
    }

    private fun displayToast(view: View) {
        if (::toast.isInitialized) toast.cancel()
        toast = Toast.makeText(this, "${if (view is Button) view.text else view.id} clicked!", Toast.LENGTH_SHORT)
        toast.show()
    }

    private fun clearDice(imageView: ImageView) {
        imageView.setImageResource( R.drawable.empty_dice)
    }

    private fun rollDice(imageView: ImageView) {
        imageView.setImageResource( getDiceImage() )
    }

    private fun getDiceImage(): Int {
        return when((1..6).random()) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
    }
}