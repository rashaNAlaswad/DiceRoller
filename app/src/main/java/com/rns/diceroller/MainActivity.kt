package com.rns.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rns.diceroller.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        rollDice()

        binding.button.setOnClickListener {
            rollDice()
        }
    }

    private fun rollDice() {
        val dice = Dice(6)
        val diceRoll = dice.roll()

        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        binding.imageView.setImageResource(drawableResource)
    }

    class Dice(private var numberOfSlides: Int) {
        fun roll(): Int {
            return (1..numberOfSlides).random()
        }
    }
}