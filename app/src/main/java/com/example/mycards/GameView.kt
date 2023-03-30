package com.example.mycards

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Paint
import android.os.Handler
import android.util.AttributeSet
import android.view.View
import com.example.mycards.Constants.SCREEN_WIDTH

class GameView: View {
        constructor(ctx: Context) : super(ctx)

        constructor(ctx: Context, attrs: AttributeSet) : super(ctx, attrs)

    private val handler = Handler();
    private val runnable = Runnable { invalidate() }
    private val paint = Paint()

    private val deck : Deck = Deck(SCREEN_WIDTH/4,resources)
    private var card:Card;
    init{
        deck.shuffle()
        card = deck.getNext();
    }



    override fun draw(canvas: Canvas) {
        super.draw(canvas)
        paint.style = Paint.Style.FILL
        card.drawCard(canvas,paint)
        handler.postDelayed(runnable, 100)
    }
    fun setCard(i: Int) {
        card = if(i>0)
            deck.getNext()
        else
            deck.getPrevious()
//        card = Card("diamonds", 1.coerceAtLeast(card.value + int).coerceAtMost(10),diamond)
    }
}