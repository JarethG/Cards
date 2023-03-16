package com.example.mycards

import android.graphics.Bitmap

class Deck constructor(val images: Array<Bitmap>) {

    private val cards: ArrayList<Card> = ArrayList();

    private var position: Int = 0

    init {
        fill()
    };

    private fun fill() {
        val suits = arrayOf("HEART","SPADE","DIAMOND","CLUB")
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
}