package com.bananarepublick.banan.blackjack;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Banan on 09.02.2018.
 */

public class LogicsDiler implements Logics {

    private int cardValue = 0;
    private Deck deck;
    private Random random;
    private Deck dilerDeck;
    private String trueFalse;

    public LogicsDiler(Deck deck) {

        this.deck = deck;
        dilerDeck = new Deck();


    }


    @Override
    public String newGameLogics() {
        dilerDeck.draw(deck);
        dilerDeck.draw(deck);
        cardValue = dilerDeck.cardsValue();
        return dilerDeck.toString();
    }

    @Override
    public ArrayList getImageCard() {

        return dilerDeck.cardsImage();
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
    @Override
    public int getResultValue(){
        return dilerDeck.cardsValue();
    }
    @Override
    public String getCard(){return dilerDeck.toString();}

    public boolean getRandomBoolean() {
        random = new Random();
        return random.nextBoolean();
    }
}
