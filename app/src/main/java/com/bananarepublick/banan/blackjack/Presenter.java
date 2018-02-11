package com.bananarepublick.banan.blackjack;

import android.util.Log;

/**
 * Created by Banan on 08.02.2018.
 */

public class Presenter {

    private Deck deck;
    private LogicsPlayer logicsPlayer;
    private LogicsDiler logicsDiler;
    private ViewGame view;
    private String resultPlayer;
    private String resultDiler;
    private int valuePlayer;
    private int valueDiler;
    boolean trueFalse = true;


    public Presenter(ViewGame view) {

        this.view = view;

    }

    public void startGame() {
        deck = new Deck();
        deck.createFullDeck();
        deck.shuffle();
        Log.d("card", deck.toString());

        logicsDiler = new LogicsDiler(deck);
        logicsPlayer = new LogicsPlayer(deck);
        cardDiler();
        cardPlayer();
        view.showCreateGame();
    }

    private void cardDiler() {

        resultDiler = logicsDiler.newGameLogics();
        resultValue();

    }


    private void cardPlayer() {

        resultPlayer = logicsPlayer.newGameLogics();
        resultValue();

    }

    public String resultCard() {

        return "Дилер " + logicsDiler.getCard() + "\n" + "Игрок " + logicsPlayer.getCard();
    }

    public void resultValue() {
        valuePlayer = logicsPlayer.getResultValue();
        valueDiler = logicsDiler.getResultValue();
        if (valuePlayer > 21 && valueDiler < 22 || valueDiler == 21 || valuePlayer > 21) {
            view.showGameOver();
            trueFalse = false;
        } else {
            if (valueDiler > 21 && valuePlayer < 22 || valuePlayer == 21 || valueDiler > 21) {
                view.showWin();
                trueFalse = false;
            }
        }

    }

    public void clickDrawButton() {

        if (trueFalse) {
            logicsPlayer.drawCard();
            logicsDiler.drawCard();
            view.showProcessGame();
        }
    }

    public void clickStopButton() {
        resultValue();
        if (trueFalse) {
            logicsDiler.drawCard();
            view.showProcessGame();
            resultValue();
        }


    }
}
