package com.bananarepublick.banan.blackjack;

import java.util.ArrayList;

/**
 * Created by Banan on 10.02.2018.
 */

public interface ViewGame {
    void showCreateGame();
    void showProcessGame();
    void showWin();
    void showGameOver();
    void setImage(ArrayList playerID,ArrayList dilerID,ArrayList playerTwo);
    void nullImage();
    void showWinTwo();
    void showGameOverTwo();
}
