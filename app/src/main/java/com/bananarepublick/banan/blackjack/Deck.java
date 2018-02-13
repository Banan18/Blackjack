package com.bananarepublick.banan.blackjack;

import android.util.Log;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Banan on 07.02.2018.
 */

public class Deck {

    private ArrayList<Card> cards;
    private int originalSizeDeck = 20;

    public Deck() {
        this.cards = new ArrayList<Card>();

    }

    public void createFullDeck() {

        for (Suit cardSuit : Suit.values()) {
            for (Value cardValue : Value.values()) {
                this.cards.add(new Card(cardSuit, cardValue));
            }
        }

    }

    // Перетосовка карт
    public void shuffle() {
        ArrayList<Card> shuffCard = new ArrayList<Card>();
        Random random = new Random();
        int randomCardIndex = 0;
        int originalSize = this.cards.size();
        for (int i = 0; i < originalSize; i++) {
            randomCardIndex = random.nextInt(((this.cards.size() - 1 - 0) + 1));
            shuffCard.add(this.cards.get(randomCardIndex));
            this.cards.remove(randomCardIndex);
        }
        this.cards = shuffCard;
    }

    public String toString() {
        String cardList = "";
        int i = 1;
        for (Card aCard : this.cards) {
            cardList += "\n" + i + aCard.toString();
            i++;
        }
        return cardList;
    }

    public void removeCard(int i) {
        this.cards.remove(i);
    }

    public Card getCard(int i) {
        return this.cards.get(i);
    }

    public void addCard(Card addCard) {
        this.cards.add(addCard);
    }

    void draw(Deck coming) {
        this.cards.add(coming.getCard(0));
        coming.removeCard(0);

    }

    public int cardsValue() {
        int totalValue = 0;
        for (Card aCard : this.cards) {
            switch (aCard.getValue()) {
                case TWO:
                    totalValue += 2;
                    break;
                case THREE:
                    totalValue += 3;
                    break;
                case FOUR:
                    totalValue += 4;
                    break;
                case FIVE:
                    totalValue += 5;
                    break;
                case SIX:
                    totalValue += 6;
                    break;
                case SEVEN:
                    totalValue += 7;
                    break;
                case EIGHT:
                    totalValue += 8;
                    break;
                case NINE:
                    totalValue += 9;
                    break;
                case TEN:
                    totalValue += 10;
                    break;
                case JACK:
                    totalValue += 10;
                    break;
                case QUEEN:
                    totalValue += 10;
                    break;
                case KING:
                    totalValue += 10;
                    break;
                case ACE:
                    // сколько начислять очков при выпадании туза
                    if (totalValue <= 10) {
                        totalValue += 11;
                    } else totalValue += 1;
                    break;
            }
        }
        return totalValue;
    }

    public ArrayList cardsImage() {
        ArrayList<Integer> imageID = new ArrayList<Integer>();
        for (Card aCard : this.cards) {
            switch (aCard.getSuit()) {
                case PIKI:
                    switch (aCard.getValue()) {
                        case TWO:
                            imageID.add(R.drawable.s2);
                            break;
                        case THREE:
                            imageID.add(R.drawable.s3);
                            break;
                        case FOUR:
                            imageID.add(R.drawable.s4);
                            break;
                        case FIVE:
                            imageID.add(R.drawable.s5);
                            break;
                        case SIX:
                            imageID.add(R.drawable.s6);
                            break;
                        case SEVEN:
                            imageID.add(R.drawable.s7);
                            break;
                        case EIGHT:
                            imageID.add(R.drawable.s8);
                            break;
                        case NINE:
                            imageID.add(R.drawable.s9);
                            break;
                        case TEN:
                            imageID.add(R.drawable.s10);
                            break;
                        case JACK:
                            imageID.add(R.drawable.sj);
                            break;
                        case QUEEN:
                            imageID.add(R.drawable.sq);
                            break;
                        case KING:
                            imageID.add(R.drawable.sk);
                            break;
                        case ACE:
                            imageID.add(R.drawable.s1);
                            break;
                    }
                    break;
                case BYBI:
                    switch (aCard.getValue()) {
                        case TWO:
                            imageID.add(R.drawable.d2);
                            break;
                        case THREE:
                            imageID.add(R.drawable.d3);
                            break;
                        case FOUR:
                            imageID.add(R.drawable.d4);
                            break;
                        case FIVE:
                            imageID.add(R.drawable.d5);
                            break;
                        case SIX:
                            imageID.add(R.drawable.d6);
                            break;
                        case SEVEN:
                            imageID.add(R.drawable.d7);
                            break;
                        case EIGHT:
                            imageID.add(R.drawable.d8);
                            break;
                        case NINE:
                            imageID.add(R.drawable.d9);
                            break;
                        case TEN:
                            imageID.add(R.drawable.d10);
                            break;
                        case JACK:
                            imageID.add(R.drawable.dj);
                            break;
                        case QUEEN:
                            imageID.add(R.drawable.dq);
                            break;
                        case KING:
                            imageID.add(R.drawable.dk);
                            break;
                        case ACE:
                            imageID.add(R.drawable.d1);
                            break;
                    }
                    break;
                case KRESTI:
                    switch(aCard.getValue()){
                        case TWO:
                            imageID.add(R.drawable.c2);
                            break;
                        case THREE:
                            imageID.add(R.drawable.c3);
                            break;
                        case FOUR:
                            imageID.add(R.drawable.c4);
                            break;
                        case FIVE:
                            imageID.add(R.drawable.c5);
                            break;
                        case SIX:
                            imageID.add(R.drawable.c6);
                            break;
                        case SEVEN:
                            imageID.add(R.drawable.c7);
                            break;
                        case EIGHT:
                            imageID.add(R.drawable.c8);
                            break;
                        case NINE:
                            imageID.add(R.drawable.c9);
                            break;
                        case TEN:
                            imageID.add(R.drawable.c10);
                            break;
                        case JACK:
                            imageID.add(R.drawable.cj);
                            break;
                        case QUEEN:
                            imageID.add(R.drawable.cq);
                            break;
                        case KING:
                            imageID.add(R.drawable.ck);
                            break;
                        case ACE:
                            imageID.add(R.drawable.c1);
                            break;
                    }
                        break;

                case CHERVI:
                    switch (aCard.getValue()){

                        case TWO:
                            imageID.add(R.drawable.h2);
                            break;
                        case THREE:
                            imageID.add(R.drawable.h3);
                            break;
                        case FOUR:
                            imageID.add(R.drawable.h4);
                            break;
                        case FIVE:
                            imageID.add(R.drawable.h5);
                            break;
                        case SIX:
                            imageID.add(R.drawable.h6);
                            break;
                        case SEVEN:
                            imageID.add(R.drawable.h7);
                            break;
                        case EIGHT:
                            imageID.add(R.drawable.h8);
                            break;
                        case NINE:
                            imageID.add(R.drawable.h9);
                            break;
                        case TEN:
                            imageID.add(R.drawable.h10);
                            break;
                        case JACK:
                            imageID.add(R.drawable.hj);
                            break;
                        case QUEEN:
                            imageID.add(R.drawable.hq);
                            break;
                        case KING:
                            imageID.add(R.drawable.hk);
                            break;
                        case ACE:
                            imageID.add(R.drawable.h1);
                            break;

                    }
                    break;
                    }



        }
        Log.d("card", String.valueOf(imageID));
        return imageID;
    }
}
