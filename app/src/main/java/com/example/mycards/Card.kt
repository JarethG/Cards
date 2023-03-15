package com.example.mycards

import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import com.example.mycards.Constants.*

class Card constructor(val type:String, val value:Int, private val image : Bitmap) {

    //3.5" x 2.5"
    private val genericScale = SCREEN_WIDTH/4
    private val cardWidth = genericScale*2.5f;
    private val cardHeight = genericScale*3.5f;
    private val shapeSize = genericScale/2;
    private val shape = Bitmap.createScaledBitmap(image,shapeSize,shapeSize,true);

    private val LEFT = (SCREEN_WIDTH-cardWidth)/2;
    private val TOP = genericScale * 1f

    val aceX : Float = (LEFT + cardWidth/2)
    val aceY : Float = (TOP + cardHeight/2)


    fun drawCard(canvas: Canvas, paint: Paint){
        paint.color = Color.GRAY
        canvas.drawRect(LEFT, TOP, (LEFT+cardWidth), (TOP+cardHeight),paint)
        drawCardType(canvas,paint);
        drawDesign(canvas,paint);
    }

    private fun drawCardType(canvas: Canvas, paint: Paint) {
        paint.textSize = shapeSize.toFloat();
        paint.color = Color.RED
        canvas.drawText(value.toString(),LEFT,TOP +shapeSize.toFloat(),paint)
        canvas.drawText(value.toString(),LEFT + cardWidth-shapeSize.toFloat(),TOP + cardHeight,paint)
    }


    private fun drawDesign(canvas: Canvas, paint: Paint) {
        for(i in 0 until value){
            canvas.drawBitmap(shape,
                LEFT +(layoutX[value-1][i]*cardWidth).toFloat() -shapeSize/2,
                TOP +(layoutY[value-1][i]*cardHeight).toFloat() -shapeSize/2,paint)
        }
    }


}