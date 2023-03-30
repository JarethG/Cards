package com.example.mycards

import android.content.Context
import android.graphics.*
import android.graphics.Color.rgb
import android.os.Handler
import android.util.AttributeSet
import android.view.View
import com.example.mycards.Constants.SCREEN_HEIGHT
import com.example.mycards.Constants.SCREEN_WIDTH

class TableView : View {
    private val handler = Handler();
    private val runnable = Runnable { invalidate() }
    private val paint = Paint()


    private val deck : Deck = Deck(150, resources)
    private var card:Card;
    private val hand : Hand = Hand(100f, SCREEN_HEIGHT*.6f, SCREEN_WIDTH-200f,250f)
    constructor(ctx: Context, attrs: AttributeSet) : super(ctx, attrs)

    init {
        deck.shuffle()
        card = deck.getNext();
        hand.addCard(deck.getNext())
        hand.addCard(deck.getNext())
        hand.addCard(deck.getNext())
        hand.addCard(deck.getNext())
        hand.addCard(deck.getNext())
    }
    override fun draw(canvas: Canvas) {
        super.draw(canvas)
        drawBackGround(canvas)
        drawOutlines(canvas)
        card.drawCard(canvas,paint)
        hand.draw(canvas,paint)
        handler.postDelayed(runnable, 100)
    }

    private fun drawBackGround(canvas: Canvas) {
        paint.color = rgb(0, 100, 0)
        paint.style = Paint.Style.FILL
        canvas.drawRect(0f,0f, SCREEN_WIDTH.toFloat(),SCREEN_HEIGHT.toFloat(),paint)
    }

    private fun drawOutlines(canvas: Canvas) {
        hand.drawBounds(canvas,paint)
    }
}