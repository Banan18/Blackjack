package com.bananarepublick.banan.blackjack;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity implements ViewGame {

    Context context = MainActivity.this;
    Presenter presenter = new Presenter(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




      //  Deck deck = new Deck();
     //   deck.createFullDeck();
     //   deck.shuffle();

     //   Log.d("Card",deck.toString());

    //    Deck deckPlayer = new Deck();


      //  deckPlayer.draw(deck);
      //  deckPlayer.draw(deck);

      //  deckDiler.diler();



      //  Toast.makeText(context,deckPlayer.toString(),Toast.LENGTH_LONG).show();
     //   Log.d("player",deckPlayer.toString());



    }

    public void buttonClickDraw(View view) {

        presenter.clickDrawButton();



    }

    public void buttonClickNewGame(View view) {

        presenter.startGame();
    }

    public void buttonClickStop(View view) {

        presenter.clickStopButton();
    }

    @Override
    public void showCreateGame() {
        Log.d("game", presenter.resultCard());

    }

    @Override
    public void showProcessGame() {
        Log.d("game",presenter.resultCard());
    }

    @Override
    public void showWin() {
        Log.d("game","Выйграл игрок");
    }

    @Override
    public void showGameOver() {
        Log.d("game","Выйграл дилер");

    }


}
