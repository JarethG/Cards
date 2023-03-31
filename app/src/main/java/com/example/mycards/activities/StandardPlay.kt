package com.example.mycards.activities

import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.mycards.GameView
import com.example.mycards.R
import com.example.mycards.TableView

class StandardPlay : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_standard_play)
        configureButton()
    }

    private fun configureButton() {
        val tb = findViewById<TableView>(R.id.tb)
        val undo = findViewById<Button>(R.id.undo)
        val draw = findViewById<Button>(R.id.draw)
        undo.setOnClickListener { tb.undo() }
        draw.setOnClickListener { tb.drawCard() }
    }
}