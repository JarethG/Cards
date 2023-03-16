package com.example.mycards

import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import com.example.mycards.Constants.*

class Card constructor(val type:String, private val trueValue:Int, private val image : Bitmap) {

    //3.5" x 2.5"
    private val genericScale = SCREEN_WIDTH/4
    private val cardWidth = genericScale*2.5f
    private val cardHeight = genericScale*3.5f
    private val shapeSize = genericScale/2
    private val shape = Bitmap.createScaledBitmap(image,shapeSize,shapeSize,true)

    private val left = (SCREEN_WIDTH-cardWidth)/2
    private val top = genericScale * 1f
    private val padding = 20

    private val value = convert(trueValue)


    fun drawCard(canvas: Canvas, paint: Paint){
        paint.style = Paint.Style.STROKE
        paint.color = Color.BLACK
        canvas.drawRect(left, top, (left+cardWidth), (top+cardHeight),paint)
        drawCardType(canvas,paint)
        drawDesign(canvas,paint)
    }

    private fun drawCardType(canvas: Canvas, paint: Paint) {
        paint.style = Paint.Style.FILL
        paint.textSize = shapeSize.toFloat()
        paint.color = Color.RED
        canvas.drawText(value,left + padding,top +shapeSize.toFloat(),paint)
        canvas.drawText(value,left + cardWidth-shapeSize.toFloat() + if(trueValue==10)-padding else padding,top + cardHeight-padding,paint)
    }


    private fun drawDesign(canvas: Canvas, paint: Paint) {
        if(trueValue>10){
            canvas.drawBitmap(shape,
                left +(layoutX[0][0]*cardWidth).toFloat() -shapeSize/2,
                top +(layoutY[0][0]*cardHeight).toFloat() -shapeSize/2,paint)
        } else {
            for (i in 0 until trueValue) {
                canvas.drawBitmap(
                    shape,
                    left + (layoutX[trueValue - 1][i] * cardWidth).toFloat() - shapeSize / 2,
                    top + (layoutY[trueValue - 1][i] * cardHeight).toFloat() - shapeSize / 2, paint
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