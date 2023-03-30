package com.example.mycards

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint

class Hand(val x:Float, val y:Float, val width:Float, val height: Float) {

    private val cards: ArrayList<Card> = ArrayList();

    fun draw(canvas: Canvas, paint: Paint) {
        val dx = width/cards.size
        for(i in 0 until cards.size){
            cards[i].draw(canvas,paint,x+dx*i,y)
        }
    }

    fun drawBounds(canvas: Canvas, paint: Paint) {
        paint.style = Paint.Style.STROKE
        paint.color = Color.WHITE
        canvas.drawRect(x,y,x+width,y+height,paint)
    }

    fun addCard(card:Card) {
        cards.add(card)
    }
}