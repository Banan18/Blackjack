package com.bananarepublick.banan.blackjack;

/**
 * Created by Banan on 07.02.2018.
 */

public class Card {

    private Suit suit;
    private Value value;

    public Card(Suit suit, Value value){
        this.suit = suit;
        this.value = value;
    }

    public String toString(){
        return this.suit.toString() + "-" + this.value.toString();
    }





    public Value getValue(){
        return this.value;
    }


}
