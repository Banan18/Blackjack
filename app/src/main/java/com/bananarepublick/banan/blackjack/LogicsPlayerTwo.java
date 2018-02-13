package com.bananarepublick.banan.blackjack;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Banan on 13.02.2018.
 */


public class LogicsPlayerTwo implements Logics {

    private Deck deck;
    private Deck playerTwoDeck;
    private int cardValue = 0;

    public LogicsPlayerTwo(Deck deck) {
        this.deck = deck;
        playerTwoDeck = new Deck();

    }

    public boolean drawCard() {
        boolean choice = false;
        if (cardValue < 10) {

            playerTwoDeck.draw(deck);
        } else {
            if (cardValue >= 12 && cardValue <= 17 && getRandomBoolean()) {
                playerTwoDeck.draw(deck);
                choice = true;
            }
        }
        return choice ;
    }

    private boolean getRandomBoolean() {
        Random random = new Random();
        return random.nextBoolean();
    }

    @Override
    public String newGameLogics() {
        playerTwoDeck.draw(deck);
        playerTwoDeck.draw(deck);
        cardValue = playerTwoDeck.cardsValue();
        return playerTwoDeck.toString();
    }

    @Override
    public ArrayList getImageCard() {
        return playerTwoDeck.cardsImage();
    }

    @Override
    public int getResultValue() {
        return playerTwoDeck.cardsValue();
    }

    @Override
    public String getCard() {
        return playerTwoDeck.toString();
    }
}
