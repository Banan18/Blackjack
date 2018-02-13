package com.bananarepublick.banan.blackjack;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ViewGame {

    Context context = MainActivity.this;
    Presenter presenter = new Presenter(this);
    Button stopButton;
    Button drawCardButton;
    ImageView imageViewPlayer;
    ImageView imageViewPlayer2;
    ImageView imageViewPlayer3;
    ImageView imageViewPlayer4;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        stopButton = (Button) findViewById(R.id.buttonStop);
        drawCardButton = (Button) findViewById(R.id.buttonCardDraw);
        imageViewPlayer = (ImageView) findViewById(R.id.imageViewPlayer);
        imageViewPlayer2 = (ImageView) findViewById(R.id.imageViewPlayer2);
        imageViewPlayer3 = (ImageView) findViewById(R.id.imageViewPlayer3);
        imageViewPlayer4 = (ImageView) findViewById(R.id.imageViewPlayer4);


        drawCardButton.setEnabled(false);
        stopButton.setEnabled(false);






    }




    public void buttonClickDraw(View view) {

        presenter.clickDrawButton();

    }

    public void buttonClickNewGame(View view) {
        presenter.startGame();
        stopButton.setEnabled(true);
        drawCardButton.setEnabled(true);



    }

    public void buttonClickStop(View view) {

        presenter.clickStopButton();
    }
    @Override
    public void nullImage(){
        imageViewPlayer.setImageDrawable(null);;
        imageViewPlayer2.setImageDrawable(null);
        imageViewPlayer3.setImageDrawable(null);
        imageViewPlayer4.setImageDrawable(null);

    }
    @Override
    public void showCreateGame() {
        Log.d("game", presenter.resultCard());

    }

    @Override
    public void showProcessGame() {
        Log.d("game", presenter.resultCard());
    }

    @Override
    public void showWin() {

        stopButton.setEnabled(false);
        drawCardButton.setEnabled(false);
        Log.d("game", "Выйграл игрок");


    }

    @Override
    public void showGameOver() {

        stopButton.setEnabled(false);
        drawCardButton.setEnabled(false);
        Log.d("game", "Выйграл дилер");


    }

    @Override
    public void setImage(ArrayList imageId) {
        for (int i = 0;i <imageId.size();i++){
            switch (i) {
                case 0:
                    imageViewPlayer.setImageResource((Integer) imageId.get(0));
                    break;
                case 1:
                    imageViewPlayer2.setImageResource((Integer) imageId.get(1));
                    break;
                case 2:
                    imageViewPlayer3.setImageResource((Integer) imageId.get(2));
                    break;
                case 3:
                    imageViewPlayer4.setImageResource((Integer) imageId.get(3));
            }
        }
        Log.d("Activity", String.valueOf(imageId));


    }



}
