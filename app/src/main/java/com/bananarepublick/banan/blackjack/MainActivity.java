package com.bananarepublick.banan.blackjack;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

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
    ImageView imageViewPlayer5;
    ImageView imageViewPlayer6;

    ImageView imageViewDiler;
    ImageView imageViewDiler2;
    ImageView imageViewDiler3;
    ImageView imageViewDiler4;
    ImageView imageViewDiler5;
    ImageView imageViewDiler6;

    ImageView imageViewPlayerTwo;
    ImageView imageViewPlayerTwo2;
    ImageView imageViewPlayerTwo3;
    ImageView imageViewPlayerTwo4;
    ImageView imageViewPlayerTwo5;
    ImageView imageViewPlayerTwo6;




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
        imageViewPlayer5 = (ImageView) findViewById(R.id.imageViewPlayer5);
        imageViewPlayer6 = (ImageView) findViewById(R.id.imageViewPlayer6);

        imageViewDiler = (ImageView) findViewById(R.id.imageViewDiler);
        imageViewDiler2 = (ImageView) findViewById(R.id.imageViewDiler2);
        imageViewDiler3 = (ImageView) findViewById(R.id.imageViewDiler3);
        imageViewDiler4 = (ImageView) findViewById(R.id.imageViewDiler4);
        imageViewDiler5 = (ImageView) findViewById(R.id.imageViewDiler5);
        imageViewDiler6 = (ImageView) findViewById(R.id.imageViewDiler6);

        imageViewPlayerTwo = (ImageView) findViewById(R.id.imageViewPlayerTwo);
        imageViewPlayerTwo2 = (ImageView) findViewById(R.id.imageViewPlayerTwo2);
        imageViewPlayerTwo3 = (ImageView) findViewById(R.id.imageViewPlayerTwo3);
        imageViewPlayerTwo4 = (ImageView) findViewById(R.id.imageViewPlayerTwo4);
        imageViewPlayerTwo5 = (ImageView) findViewById(R.id.imageViewPlayerTwo5);
        imageViewPlayerTwo6 = (ImageView) findViewById(R.id.imageViewPlayerTwo6);


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
        imageViewPlayer.setImageDrawable(null);
        imageViewPlayer2.setImageDrawable(null);
        imageViewPlayer3.setImageDrawable(null);
        imageViewPlayer4.setImageDrawable(null);
        imageViewPlayer5.setImageDrawable(null);
        imageViewPlayer6.setImageDrawable(null);

        imageViewDiler.setImageDrawable(null);
        imageViewDiler2.setImageDrawable(null);
        imageViewDiler3.setImageDrawable(null);
        imageViewDiler4.setImageDrawable(null);
        imageViewDiler5.setImageDrawable(null);
        imageViewDiler6.setImageDrawable(null);

        imageViewPlayerTwo.setImageDrawable(null);
        imageViewPlayerTwo2.setImageDrawable(null);
        imageViewPlayerTwo3.setImageDrawable(null);
        imageViewPlayerTwo4.setImageDrawable(null);
        imageViewPlayerTwo5.setImageDrawable(null);
        imageViewPlayerTwo6.setImageDrawable(null);
    }

    @Override
    public void showWinTwo() {
        stopButton.setEnabled(false);
        drawCardButton.setEnabled(false);
        Toast.makeText(this,"Выйграли вы и игрок",Toast.LENGTH_SHORT).show();

        Log.d("game","Выйграли вы и игрок");
    }

    @Override
    public void showGameOverTwo() {

        stopButton.setEnabled(false);
        drawCardButton.setEnabled(false);
        Toast.makeText(this,"Выйграл второй игрок",Toast.LENGTH_SHORT).show();
        Log.d("game","Выйграл второй игрок");

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
        Toast.makeText(this,"Выйграл игрок",Toast.LENGTH_SHORT).show();
        Log.d("game", "Выйграл игрок");


    }

    @Override
    public void showGameOver() {

        stopButton.setEnabled(false);
        drawCardButton.setEnabled(false);
        Toast.makeText(this,"Выйграл дилер",Toast.LENGTH_SHORT).show();
        Log.d("game", "Выйграл дилер");


    }

    @Override
    public void setImage(ArrayList playerId,ArrayList dilerID,ArrayList playerTwo) {
        for (int i = 0;i <playerId.size();i++){
            switch (i) {
                case 0:
                    imageViewPlayer.setImageResource((Integer) playerId.get(0));
                    break;
                case 1:
                    imageViewPlayer2.setImageResource((Integer) playerId.get(1));
                    break;
                case 2:
                    imageViewPlayer3.setImageResource((Integer) playerId.get(2));
                    break;
                case 3:
                    imageViewPlayer4.setImageResource((Integer) playerId.get(3));
                    break;
                case 4:
                    imageViewPlayer5.setImageResource((Integer) playerId.get(4));
                    break;
                case 5:
                    imageViewPlayer6.setImageResource((Integer) playerId.get(5));
                    break;
            }
        }

        for (int i = 0;i <dilerID.size();i++){
            switch (i) {
                case 0:
                    imageViewDiler.setImageResource((Integer) dilerID.get(0));
                    break;
                case 1:
                    imageViewDiler2.setImageResource(R.drawable.defaultcard);
                    break;
                case 2:
                    imageViewDiler2.setImageResource((Integer) dilerID.get(1));
                    imageViewDiler3.setImageResource((Integer) dilerID.get(2));
                    break;
                case 3:
                    imageViewDiler4.setImageResource((Integer) dilerID.get(3));
                    break;
                case 4:
                    imageViewDiler5.setImageResource((Integer) dilerID.get(4));
                    break;
                case 5:
                    imageViewDiler6.setImageResource((Integer) dilerID.get(5));
                    break;
            }


        }
        for (int i = 0;i <playerTwo.size();i++){
            switch (i) {
                case 0:
                    imageViewPlayerTwo.setImageResource((Integer) playerTwo.get(0));
                    break;
                case 1:
                    imageViewPlayerTwo2.setImageResource((Integer) playerTwo.get(1));
                    break;
                case 2:
                    imageViewPlayerTwo3.setImageResource((Integer) playerTwo.get(2));
                    break;
                case 3:
                    imageViewPlayerTwo4.setImageResource((Integer) playerTwo.get(3));
                    break;
                case 4:
                    imageViewPlayerTwo5.setImageResource((Integer) playerTwo.get(4));
                    break;
                case 5:
                    imageViewPlayerTwo6.setImageResource((Integer) playerTwo.get(5));
                    break;
            }
        }
        Log.d("Activity", String.valueOf(playerId));


    }



}
