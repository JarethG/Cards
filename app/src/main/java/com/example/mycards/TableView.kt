package com.example.mycards

import android.content.Context
import android.graphics.*
import android.graphics.Color.rgb
import android.os.Handler
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import com.example.mycards.Constants.*

class TableView : View {
    private val handler = Handler();
    private val runnable = Runnable { invalidate() }
    private val paint = Paint()


    private val deck : Deck = Deck(150, resources)
    private val hand : Hand = Hand(100f, SCREEN_HEIGHT*.6f, SCREEN_WIDTH-200f,cardHeight)
    private val pile : PlayPile = PlayPile()
    constructor(ctx: Context, attrs: AttributeSet) : super(ctx, attrs)

    init {
        deck.shuffle()
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
        hand.draw(canvas,paint)
        drawPile(canvas)
        handler.postDelayed(runnable, 100)
    }

    private fun drawPile(canvas: Canvas) {
        if(pile.empty()) return
        pile.getTopCard().draw(canvas,paint,SCREEN_WIDTH/2f- cardWidth/2,300f)

    }

    private fun drawBackGround(canvas: Canvas) {
        paint.color = rgb(0, 100, 0)
        paint.style = Paint.Style.FILL
        canvas.drawRect(0f,0f, SCREEN_WIDTH.toFloat(),SCREEN_HEIGHT.toFloat(),paint)
    }

    private fun drawOutlines(canvas: Canvas) {
        hand.drawBounds(canvas,paint)
        canvas.drawRect(SCREEN_WIDTH/2f- cardWidth/2,300f, SCREEN_WIDTH/2f + cardWidth/2,300f + cardHeight,paint)
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        if(event.actionMasked==MotionEvent.ACTION_DOWN)
        if(hand.getBounds().contains(event.x.toInt(), event.y.toInt())){
            if(!hand.isEmpty()) {
                pile.play(hand.getCard(event.x, event.y))
            }
        }
        return true
    }

    fun undo() {
        if(!pile.empty())
        hand.addCard(pile.undo())
    }

    fun drawCard() {
        if(!deck.empty())
            hand.addCard(deck.getNext())
    }
}