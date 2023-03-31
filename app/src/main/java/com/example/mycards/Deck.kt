package com.example.mycards

import android.content.res.Resources
import android.graphics.*

class Deck( deckWidth: Int, resources: Resources) {

    private val suits: Bitmap = Bitmap.createScaledBitmap(
        BitmapFactory.decodeResource(resources,R.drawable.suitsclear),
        deckWidth*4,deckWidth,true);

    private val spade: Bitmap = Bitmap.createBitmap(suits,0,0,deckWidth,deckWidth);
    private val diamond: Bitmap = Bitmap.createBitmap(suits,1*deckWidth,0,deckWidth,deckWidth);
    private val club: Bitmap = Bitmap.createBitmap(suits,2*deckWidth,0,deckWidth,deckWidth);
    private val heart: Bitmap = Bitmap.createBitmap(suits,3*deckWidth,0,deckWidth,deckWidth);

    private val cards: ArrayList<Card> = ArrayList();
    private var position: Int = 0

    init {
        fill()
    };

    private fun fill() {
        val suits = arrayOf("HEART","SPADE","DIAMOND","CLUB")
        val images = arrayOf(heart,spade,diamond,club)
        for (s in 0 until 4) {
            for (i in 0 until 13)
                cards.add(
                    Card(suits[s], i + 1, images[s])
                )
        }
    }

    public fun getNext(): Card {
        if (position < 52)
            position++;
        return cards[position];
    }

    public fun getPrevious(): Card {
        if (position != 0)
            position--;
        return cards[position];
    }

    public fun shuffle() {
        cards.shuffle()
    }

    fun empty():Boolean{
        return cards.isEmpty()
    }
}