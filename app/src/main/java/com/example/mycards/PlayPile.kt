package com.example.mycards

import java.util.*

class PlayPile {
    private val stack : Stack<Card> = Stack()
    fun play(card:Card){
        stack.push(card)
    }
    fun getTopCard():Card{
        return stack.peek()
    }
    fun undo() : Card {
        return stack.pop()
    }
    fun empty():Boolean  {
        return stack.empty();
    }
}