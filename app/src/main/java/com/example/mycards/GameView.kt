package com.example.mycards

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class GameView: View {
        constructor(ctx: Context) : super(ctx)

        constructor(ctx: Context, attrs: AttributeSet) : super(ctx, attrs)
    private val staticScale = 200;

    private val suits: Bitmap = Bitmap.createScaledBitmap(
        BitmapFactory.decodeResource(resources,R.drawable.suits),
800,200,true);
    private val spade: Bitmap = Bitmap.createBitmap(suits,0,0,staticScale,staticScale);
    private val diamond: Bitmap = Bitmap.createBitmap(suits,1*staticScale,0,staticScale,staticScale);
    private val club: Bitmap = Bitmap.createBitmap(suits,2*staticScale,0,staticScale,staticScale);
    private val heart: Bitmap = Bitmap.createBitmap(suits,3*staticScale,0,staticScale,staticScale);
    private val paint = Paint()


    override fun draw(canvas: Canvas) {
        super.draw(canvas)
        canvas.drawBitmap(spade,200f,400f,paint)
    }
}