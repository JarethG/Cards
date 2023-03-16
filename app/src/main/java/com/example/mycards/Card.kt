package com.example.mycards

import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import com.example.mycards.Constants.*

class Card constructor(val type:String, val trueValue:Int, private val image : Bitmap) {

    //3.5" x 2.5"
    private val genericScale = SCREEN_WIDTH/4
    private val cardWidth = genericScale*2.5f;
    private val cardHeight = genericScale*3.5f;
    private val shapeSize = genericScale/2;
    private val shape = Bitmap.createScaledBitmap(image,shapeSize,shapeSize,true);

    private val LEFT = (SCREEN_WIDTH-cardWidth)/2;
    private val TOP = genericScale * 1f
    private val PADDING = 20

    private val value = convert(trueValue)


    fun drawCard(canvas: Canvas, paint: Paint){
        paint.style = Paint.Style.STROKE
        paint.color = Color.BLACK
        canvas.drawRect(LEFT, TOP, (LEFT+cardWidth), (TOP+cardHeight),paint)
        drawCardType(canvas,paint);
        drawDesign(canvas,paint);
    }

    private fun drawCardType(canvas: Canvas, paint: Paint) {
        paint.style = Paint.Style.FILL
        paint.textSize = shapeSize.toFloat();
        paint.color = Color.RED
        canvas.drawText(value,LEFT + PADDING,TOP +shapeSize.toFloat(),paint)
        canvas.drawText(value,LEFT + cardWidth-shapeSize.toFloat() + if(trueValue==10)-PADDING else PADDING,TOP + cardHeight-PADDING,paint)
    }


    private fun drawDesign(canvas: Canvas, paint: Paint) {
        if(trueValue>10){
            canvas.drawBitmap(shape,
                LEFT +(layoutX[0][0]*cardWidth).toFloat() -shapeSize/2,
                TOP +(layoutY[0][0]*cardHeight).toFloat() -shapeSize/2,paint)
        } else {
            for (i in 0 until trueValue) {
                canvas.drawBitmap(
                    shape,
                    LEFT + (layoutX[trueValue - 1][i] * cardWidth).toFloat() - shapeSize / 2,
                    TOP + (layoutY[trueValue - 1][i] * cardHeight).toFloat() - shapeSize / 2, paint
                )
            }
        }
    }

    private fun convert(value : Int) : String{
        return when (value) {
            1 -> "A"
            11 -> "J"
            12 -> "Q"
            13 -> "K"
            else -> value.toString()
        }
    }


}