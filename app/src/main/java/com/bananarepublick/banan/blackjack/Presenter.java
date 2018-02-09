package com.bananarepublick.banan.blackjack;

/**
 * Created by Banan on 08.02.2018.
 */

public class Presenter {

    private Deck deck;


    public Presenter(){
        deck = new Deck();
        deck.createFullDeck();
        deck.shuffle();

    }

    public String diler(){

        LogicsDiler logicsDiler = new LogicsDiler(deck);


        return logicsDiler.playLogicDiler()+" "+logicsDiler.getRandomBoolean();
    }

    public String player(){

        Deck playesDeck = new Deck();
        playesDeck.draw(deck);
        playesDeck.draw(deck);
        return playesDeck.toString();
    }

}
