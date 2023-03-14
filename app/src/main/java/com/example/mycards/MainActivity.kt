package com.example.mycards

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        configureStartButton()
    }

    private fun configureStartButton() {
        val start = findViewById<Button>(R.id.b1)
        start.setOnClickListener { startActivity(Intent(this, ShuffledDeck::class.java)) }
    }
}