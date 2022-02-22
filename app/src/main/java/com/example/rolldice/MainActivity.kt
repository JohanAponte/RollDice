package com.example.rolldice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast

/**
 * This activity allows the user to roll a dice and view the result
 * on the screen
 */

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)

        rollDice()

        rollButton.setOnClickListener {
            Toast.makeText(this, "Dice Rolled!", Toast.LENGTH_SHORT).show()
            /*val resultTextView: TextView = findViewById(R.id.textView)
            val myDice = Dice(12)
            resultTextView.text = myDice.roll().toString()
            */
            rollDice()
        }
    }

    /**
     * Roll the dice and update the screen with the result
     */
    private fun rollDice() {
        // Create new Dice object with 6 sides and roll it
        val myDiceOne = Dice(6)
        val diceRollOne = myDiceOne.roll()

        val myDiceTwo = Dice(6)
        val diceRollTwo = myDiceTwo.roll()
        // Update the screen with the dice roll
        val diceImageOne: ImageView = findViewById(R.id.imageView)
        val diceImageTwo: ImageView = findViewById(R.id.imageView2)

        val drawableResourceOne = getResource(diceRollOne)
        val drawableResourceTwo = getResource(diceRollTwo)

        diceImageOne.setImageResource(drawableResourceOne)
        diceImageOne.contentDescription = diceRollOne.toString()

        diceImageTwo.setImageResource(drawableResourceTwo)
        diceImageTwo.contentDescription = diceRollTwo.toString()

    }

    private fun getResource(diceNumber: Int): Int {

        val drawableResource = when(diceNumber){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        return drawableResource
    }

}


class Dice(private val numSides: Int) {

    fun roll(): Int {
        return (1..numSides).random()
    }
}