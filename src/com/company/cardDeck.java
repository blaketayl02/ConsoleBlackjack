package com.company;


import java.util.ArrayList;
import java.util.Collections;

public class cardDeck {


    private ArrayList<Card> deck;

    public cardDeck() {
        deck = new ArrayList<>();
        String[] suits = {"Diamonds","Spades","Hearts","Clubs"};
        for(String suit: suits){
            for(int j = 1; j <= 13; j++) {
                deck.add(new Card(j, suit));
            }
            Collections.shuffle(deck);
        }

    }
    public Card draw(){
        return deck.remove(deck.size()-1);
    }

}

