package com.bananarepublick.banan.blackjack;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Banan on 07.02.2018.
 */

public class Deck {

    private ArrayList<Card> cards;

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
                    // сколько начислять очков при попадании туза
                    if (totalValue <= 10) {
                        totalValue += 11;
                    } else totalValue += 1;
                    break;
            }
        }
        return totalValue;
    }


}
