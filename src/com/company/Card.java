package com.company;

import java.security.SecureRandom;

public class Card {
    //public static String facecards[] = {"Jack", "Queen", "King"};
    public int cardValue;
    public String suit;
    public String card;


    @Override
    public String toString() {
        return card + " of " + suit;
    }

    public Card(int cardValue, String suit) {
        this.suit = suit;
        this.cardValue = cardValue;
//        this.card = card;
        if (cardValue == 11){
            this.card = "Jack";
        }
        else if (cardValue == 12){
            this.card = "Queen";

        }
        else if (cardValue == 13) {
            this.card = "King";
        }
        else if (cardValue == 1){
            this.card = "Ace";
            this.cardValue = 11;
        }
        else{
            this.card = "" + cardValue;
        }

        if(cardValue > 10 && !card.equals("Ace")) {
            this.cardValue = 10;
        }
    }
}

