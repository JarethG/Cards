package com.example.mycards.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.DisplayMetrics
import android.widget.Button
import com.example.mycards.Constants
import com.example.mycards.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val displayMetrics = DisplayMetrics()
        this.windowManager.defaultDisplay.getMetrics(displayMetrics);
        Constants.SCREEN_WIDTH = displayMetrics.widthPixels
        Constants.SCREEN_HEIGHT = displayMetrics.heightPixels
        configureStartButton()
    }

    private fun configureStartButton() {
        val start = findViewById<Button>(R.id.b1)
        start.setOnClickListener { startActivity(Intent(this, ShuffledDeck::class.java)) }
    }
}