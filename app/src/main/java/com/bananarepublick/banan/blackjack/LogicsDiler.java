package com.bananarepublick.banan.blackjack;

import java.util.Random;

/**
 * Created by Banan on 09.02.2018.
 */

public class LogicsDiler {

    private int cardValue;
    private Deck deck;
    private Random random;
    private Deck dilerDeck = new Deck();

    public LogicsDiler(Deck deck){

        this.deck = deck;

    }

    public String playLogicDiler(){

        dilerDeck.draw(deck);
        dilerDeck.draw(deck);

        cardValue = dilerDeck.cardsValue();
        drawCardDiler();
        return dilerDeck.toString()+" Ox4u "+dilerDeck.cardsValue();
    }

     private boolean drawCardDiler(){
        boolean drawChoice = false;
        if (cardValue < 10){
            drawChoice = true;
            dilerDeck.draw(deck);
        }
        else {
            if (cardValue >= 10 && cardValue <= 16 && getRandomBoolean()){
                dilerDeck.draw(deck);


            }
        }
        return drawChoice ;
    }

    public boolean getRandomBoolean(){
        random = new Random();
        return random.nextBoolean();
    }

}
