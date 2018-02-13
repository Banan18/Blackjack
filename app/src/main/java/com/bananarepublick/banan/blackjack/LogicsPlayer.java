package com.bananarepublick.banan.blackjack;

import java.util.ArrayList;

/**
 * Created by Banan on 09.02.2018.
 */

public class LogicsPlayer implements Logics {
   private Deck deck;
   private Deck playerDeck;
   private String gameOver ="Игрок выйграл";


    public LogicsPlayer(Deck deck) {
        this.deck = deck;
        playerDeck = new Deck();
    }


    @Override
    public String newGameLogics() {

            playerDeck.draw(deck);
            playerDeck.draw(deck);
        return playerDeck.toString();
    }


    public void drawCard() {
        if (playerDeck.cardsValue() < 21) {
            playerDeck.draw(deck);
        }
    }
    public ArrayList getImageCard(){
       return playerDeck.cardsImage();
    }


    public String getCard(){return playerDeck.toString();}
    public int getResultValue(){
        return playerDeck.cardsValue();
    }
}
