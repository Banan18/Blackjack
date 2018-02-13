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
    private LogicsPlayerTwo logicsPlayerTwo;
    private ViewGame view;
    private int valuePlayer;
    private int valueDiler;
    private  int valuePlayerTwo;
    private boolean trueFalse = true;
    private boolean gameOver;
    Deck playerDeck;


    public Presenter(ViewGame view) {

        this.view = view;

    }

    public void startGame() {
        view.nullImage();
        deck = new Deck();
        deck.numDeck();

        trueFalse = true;
        gameOver = false;
        logicsPlayer = new LogicsPlayer(deck);
        logicsPlayerTwo = new LogicsPlayerTwo(deck);
        logicsDiler = new LogicsDiler(deck);

        cardDiler();
        cardPlayer();
        cardPlayerTwo();

        view.showCreateGame();
        cardImage();

    }


    private void cardDiler() {

        logicsDiler.newGameLogics();
        resultValue();

    }

    private void cardPlayerTwo() {

        logicsPlayerTwo.newGameLogics();
        resultValue();

    }




    private void cardPlayer() {

        logicsPlayer.newGameLogics();
        resultValue();

    }

    public String resultCard() {

        return "Дилер " + logicsDiler.getCard() + "\n" + "Игрок " + logicsPlayer.getCard()+"\n"+"Игрок 2 "+logicsPlayerTwo.getCard();
    }
// с логикой беда
    public void resultValue() {
        valuePlayer = logicsPlayer.getResultValue();
        valueDiler = logicsDiler.getResultValue();
        valuePlayerTwo = logicsPlayerTwo.getResultValue();

        if (trueFalse){
            if (valuePlayer == 21 ||valuePlayer == 21 && valueDiler ==21){
                view.showWin();
                trueFalse = false;
            }
            if (valuePlayer == 21&& valuePlayerTwo == 21){
                view.showWinTwo();
                trueFalse = false;
            }
            if (valuePlayerTwo ==21 || valuePlayerTwo == 21 && valueDiler ==21){
                view.showGameOverTwo();
                trueFalse = false;
            }
            if (valuePlayer < 22 && valuePlayerTwo > 21 && valueDiler > 21){
                view.showWin();
                trueFalse = false;
            }
            if (valuePlayerTwo < 22 && valuePlayer > 21 && valueDiler > 21){
                view.showGameOverTwo();
                trueFalse = false;
            }
            if (valueDiler < 22 && valuePlayerTwo > 21 && valuePlayer > 21){
                view.showGameOver();
                trueFalse = false;
            }
            if (gameOver){
              if (valuePlayerTwo < 22 && valuePlayer < 22 && valueDiler <22){
                  if (valuePlayer > valuePlayerTwo && valuePlayer > valueDiler){
                      view.showWin();
                  }else {
                      if (valuePlayerTwo > valuePlayer && valuePlayerTwo > valueDiler){
                          view.showGameOverTwo();
                      }else {
                          if (valueDiler > valuePlayer && valueDiler > valuePlayerTwo){
                              view.showGameOver();
                          }
                      }
                  }
              }
              if(valuePlayerTwo< 22 && valuePlayer < 22){
                  if (valuePlayer > valuePlayerTwo){
                      view.showWin();
                  }else view.showGameOverTwo();
              }
              if (valuePlayer < 22 && valueDiler < 22){
                  if (valuePlayer > valueDiler){
                      view.showWin();
                  }else view.showGameOver();
              }
              if (valuePlayerTwo < 22 && valueDiler < 22){
                  if (valuePlayerTwo > valueDiler){
                      view.showGameOverTwo();
                  }else view.showGameOver();
              }

            }
        }

/*        if (trueFalse) {
            if (valuePlayer == 21 && valueDiler == 21) {
                view.showWin();
                trueFalse = false;
            } else {
                if (valuePlayerTwo == 21 &&valuePlayer ==21){
                    view.showWinTwo();
                    trueFalse = false;
                }
                if (valuePlayer > 21 && valueDiler > 21 && valuePlayerTwo < 22 ||valuePlayerTwo == 21){
                    view.showGameOverTwo();
                    trueFalse = false;
                }
                if (valuePlayer > 21 && valueDiler < 22 || valueDiler == 21 || valuePlayer > 21) {
                    view.showGameOver();
                    trueFalse = false;
                } else {
                    if (valueDiler > 21 && valuePlayer < 22 || valuePlayer == 21 || valueDiler > 21) {
                        view.showWin();
                        trueFalse = false;
                    } else {
                        if (gameOver) {
                            if (valuePlayer > valueDiler && valuePlayer > valuePlayerTwo && valuePlayer > valuePlayerTwo) view.showWin();
                            else {
                                if (valuePlayerTwo > valueDiler || valuePlayerTwo == 21){
                                    view.showGameOverTwo();
                                }else view.showGameOver();
                            }

                        }
                    }
                }
            }
        }*/
    }

    public void clickDrawButton() {
        resultValue();
        if (trueFalse) {
            logicsPlayer.drawCard();
            logicsDiler.drawCard();
            logicsPlayerTwo.drawCard();
            view.showProcessGame();
            resultValue();
            cardImage();
        }
    }

    public void clickStopButton() {
        resultValue();
        if (trueFalse) {
            while (logicsDiler.drawCard()) {
                logicsPlayerTwo.drawCard();
                view.showProcessGame();
                cardImage();
            }
            gameOver = true;
            resultValue();
            cardImage();


        }
    }

    public void cardImage() {
        ArrayList player = logicsPlayer.getImageCard();
        ArrayList diler = logicsDiler.getImageCard();
        ArrayList playerTwo = logicsPlayerTwo.getImageCard();


                view.setImage(player,diler,playerTwo);
                Log.d("imagetwo", String.valueOf(playerTwo));





        }

    }





