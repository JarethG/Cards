package com.example.mycards

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class ShuffledDeck : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shuffled_deck)
        configureBackButton()
        configureOtherButtons()
    }

    private fun configureBackButton() {
        val start = findViewById<Button>(R.id.back)
        start.setOnClickListener { startActivity(Intent(this, MainActivity::class.java)) }
    }

    private fun configureOtherButtons() {
        val gv =findViewById<GameView>(R.id.gv)
        val up = findViewById<Button>(R.id.up)
        up.setOnClickListener { gv.setCard(+1) }
        val down = findViewById<Button>(R.id.down)
        down.setOnClickListener { gv.setCard(-1) }
    }
}