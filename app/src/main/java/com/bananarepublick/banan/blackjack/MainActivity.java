package com.bananarepublick.banan.blackjack;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Context context = MainActivity.this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



      //  Deck deck = new Deck();
     //   deck.createFullDeck();
     //   deck.shuffle();

     //   Log.d("Card",deck.toString());

    //    Deck deckPlayer = new Deck();
        Presenter deckDiler = new Presenter();

      //  deckPlayer.draw(deck);
      //  deckPlayer.draw(deck);

      //  deckDiler.diler();



      //  Toast.makeText(context,deckPlayer.toString(),Toast.LENGTH_LONG).show();
     //   Log.d("player",deckPlayer.toString());
        Log.d("dil",deckDiler.diler());
        Log.d("pla",deckDiler.player());


    }

    void showWinMessage() {
        Toast.makeText(context, "Вы выиграли", Toast.LENGTH_LONG).show();
    }

    void showGameOverMessage() {
        Toast.makeText(context, "Вы проиграли", Toast.LENGTH_LONG).show();
    }

    void createNewGame() {

    }
}
