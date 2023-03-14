package com.example.mycards

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Paint

class Card constructor(val type:String, private val value:String, private val image : Bitmap) {

    //3.5" x 2.5"
    private val genericScale = 100f
    private val cardWidth = genericScale*2.5f;
    private val cardHeight = genericScale*3.5f;

    private val LEFT = 200;
    private val TOP = 300;

    val aceX = cardWidth/2;
    val aceY = cardHeight/2;


    fun drawCard(canvas: Canvas, paint: Paint){
        canvas.drawRect(LEFT.toFloat(),
            TOP.toFloat(), (LEFT+cardWidth).toFloat(), (TOP+cardHeight).toFloat(),paint)
        drawCardType(canvas,paint);
        drawDesign(canvas,paint);
    }

    private fun drawCardType(canvas: Canvas, paint: Paint) {
        canvas.drawText(value,30f,30f,paint)
    }

    private fun drawDesign(canvas: Canvas, paint: Paint) {
        canvas.drawBitmap(image,aceX,aceY,paint)
    }


}