package com.bananarepublick.banan.blackjack;

import java.util.Random;

/**
 * Created by Banan on 09.02.2018.
 */

public class LogicsDiler implements Logics {

    private int cardValue = 0;
    private Deck deck;
    private Random random;
    private Deck dilerDeck = new Deck();
    private String trueFalse;

    public LogicsDiler(Deck deck) {

        this.deck = deck;

    }


    @Override
    public String newGameLogics() {
        dilerDeck.draw(deck);
        dilerDeck.draw(deck);
        cardValue = dilerDeck.cardsValue();
        return dilerDeck.toString();
    }


    public boolean drawCard() {
        boolean choice = false;
        if (cardValue < 10) {

            dilerDeck.draw(deck);
        } else {
            if (cardValue >= 10 && cardValue <= 16 && getRandomBoolean()) {
                dilerDeck.draw(deck);
                choice = true;
            }
        }
        return choice ;
    }
    public int getResultValue(){
        return dilerDeck.cardsValue();
    }
    public String getCard(){return dilerDeck.toString();}

    public boolean getRandomBoolean() {
        random = new Random();
        return random.nextBoolean();
    }
}
