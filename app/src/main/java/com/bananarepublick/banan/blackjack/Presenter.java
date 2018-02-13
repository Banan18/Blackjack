package com.bananarepublick.banan.blackjack;

import android.util.Log;

import java.util.ArrayList;

/**
 * Created by Banan on 08.02.2018.
 */

public class Presenter {

    private Deck deck;
    private LogicsPlayer logicsPlayer;
    private LogicsDiler logicsDiler;
    private ViewGame view;
    private int valuePlayer;
    private int valueDiler;
    private boolean trueFalse;
    private boolean gameOver;


    public Presenter(ViewGame view) {

        this.view = view;

    }

    public void startGame() {
        view.nullImage();
        deck = new Deck();
        deck.createFullDeck();
        deck.shuffle();

        trueFalse = true;
        gameOver = false;
        logicsDiler = new LogicsDiler(deck);
        logicsPlayer = new LogicsPlayer(deck);
        cardDiler();
        cardPlayer();

        view.showCreateGame();
        cardImage();
    }


    private void cardDiler() {

        logicsDiler.newGameLogics();
        resultValue();

    }


    private void cardPlayer() {

        logicsPlayer.newGameLogics();
        resultValue();

    }

    public String resultCard() {

        return "Дилер " + logicsDiler.getCard() + "\n" + "Игрок " + logicsPlayer.getCard();
    }

    public void resultValue() {
        valuePlayer = logicsPlayer.getResultValue();
        valueDiler = logicsDiler.getResultValue();
        if (trueFalse) {
            if (valuePlayer == 21 && valueDiler == 21) {
                view.showWin();
                trueFalse = false;
            } else {
                if (valuePlayer > 21 && valueDiler < 22 || valueDiler == 21 || valuePlayer > 21) {
                    view.showGameOver();
                    trueFalse = false;
                } else {
                    if (valueDiler > 21 && valuePlayer < 22 || valuePlayer == 21 || valueDiler > 21) {
                        view.showWin();
                        trueFalse = false;
                    } else {
                        if (gameOver) {
                            if (valuePlayer > valueDiler) view.showWin();
                            else view.showGameOver();
                        }
                    }
                }
            }
        }
    }

    public void clickDrawButton() {
        resultValue();
        if (trueFalse) {
            logicsPlayer.drawCard();
            logicsDiler.drawCard();
            view.showProcessGame();
            resultValue();
            cardImage();
        }
    }

    public void clickStopButton() {
        resultValue();
        if (trueFalse) {
            while (logicsDiler.drawCard()) {
                view.showProcessGame();
            }
            gameOver = true;
            resultValue();

        }
    }

    public void cardImage() {
        ArrayList<Integer> image = logicsPlayer.getImageCard();
            if (image.size() != 0){
                view.setImage(image);
                Log.d("image", String.valueOf(image));
            }




        }

    }





