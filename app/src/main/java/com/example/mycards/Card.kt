package com.example.mycards

import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import com.example.mycards.Constants.*

class Card(val type:String, private val trueValue:Int, private val image: Bitmap) {

    //3.5" x 2.5"
    private val shapeSize = (genericScale/2)
    private val shape = Bitmap.createScaledBitmap(image,shapeSize,shapeSize,true)
    private val padding = 20

    private val value = convert(trueValue)


    fun draw(canvas: Canvas, paint: Paint,x: Float, y: Float){
        canvas.translate(x, y)
        drawEmptyCard(canvas,paint)
        drawCardType(canvas,paint)
        drawDesign(canvas,paint)
        canvas.translate(-x, -y)

    }

    private fun drawEmptyCard(canvas: Canvas, paint: Paint){
        paint.style = Paint.Style.FILL
        paint.color = Color.WHITE
        canvas.drawRect(0F,0F,cardWidth, cardHeight,paint)
        paint.style = Paint.Style.STROKE
        paint.color = Color.BLACK
        canvas.drawRect(0F, 0F, cardWidth, cardHeight,paint)
    }

    private fun drawCardType(canvas: Canvas, paint: Paint) {
        paint.style = Paint.Style.FILL
        paint.textSize = shapeSize.toFloat()
        paint.color = Color.RED
        canvas.drawText(value, padding.toFloat(),shapeSize.toFloat(),paint)
        canvas.drawText(value,cardWidth-shapeSize.toFloat() + if(trueValue==10)-padding else padding,cardHeight-padding,paint)
    }


    private fun drawDesign(canvas: Canvas, paint: Paint) {
        if(trueValue>10){
            canvas.drawBitmap(shape,
               (layoutX[0][0]*cardWidth).toFloat() -shapeSize/2,
                (layoutY[0][0]*cardHeight).toFloat() -shapeSize/2,paint)
        } else {
            for (i in 0 until trueValue) {
                canvas.drawBitmap(
                    shape,
                    (layoutX[trueValue - 1][i] * cardWidth).toFloat() - shapeSize / 2,
                    (layoutY[trueValue - 1][i] * cardHeight).toFloat() - shapeSize / 2, paint
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

    override fun toString(): String {
        return "$value | $type"
    }

}