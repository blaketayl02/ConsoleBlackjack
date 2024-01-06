package com.company;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class Blackjack extends Game{
    private  boolean bustCheck = false;
    private  boolean hasWon = false;
    private  ArrayList<Card> playerHand = new ArrayList<Card>();
    private  ArrayList<Card> dealerHand = new ArrayList<Card>();

    public Blackjack(Player p) {
        super(p);
    }


    public  void startGame(){
        getBetAmount();
        Scanner scanner = new Scanner(System.in);
        cardDeck deck = new cardDeck();


        playerHand.add(deck.draw());
        playerHand.add(deck.draw());
        System.out.println("Your cards: ");
        System.out.println(playerHand.get(0));
        System.out.println(playerHand.get(1));

        dealerHand.add(deck.draw());
        dealerHand.add(deck.draw());
        System.out.println("Dealer card: ");
        System.out.println(dealerHand.get(0));

        while(!bustCheck && !hasWon) {
            System.out.println("Would you like to hit or stand?" + " hit, stand");
            if (scanner.nextLine().equals("hit")) {
                Card pDraw = deck.draw();
                playerHand.add(pDraw);
                setAceValue(playerHand);
                System.out.println("You have drawn a/an " + pDraw);
            }
            else if(!bustCheck){
                while(!dealerStand() && getValue(dealerHand) < 21){
                    dealerHand.add(deck.draw());
                    setAceValue(dealerHand);
                }
                if(getValue(dealerHand) == getValue(playerHand)) {
                    System.out.println("Equal hand values, no win");
                    return;
                }
                if(getValue(dealerHand) > getValue(playerHand) && getValue(dealerHand) <= 21){
                    System.out.println("Dealer has won.");
                    System.out.println("Dealer's hand value: " + getValue(dealerHand));
                    System.out.println("Your hand's value: " + getValue(playerHand));
                    player.balance -= betamount;
                }
                if(getValue(dealerHand) < getValue(playerHand) || getValue(dealerHand) > 21){
                    System.out.println("You have won!");
                    System.out.println("Dealer's hand value: " + getValue(dealerHand));
                    System.out.println("Your hand's value: " + getValue(playerHand));
                    hasWon = true;
                    player.balance += betamount;
                }
                break;
            }
            if(getValue(playerHand) == 21){
                System.out.println("Blackjack! You win");
                player.balance += betamount;
                hasWon = true;
            }
            else if(getValue(playerHand) > 21){
                System.out.println("You have busted");
                player.balance -= betamount;
                bustCheck = true;
            }

        }

        if(hasWon)
            System.out.println("Thank you for playing, you have won!");
        else
            System.out.println("You've lost, thanks for playing");
    }

    private int getValue(ArrayList<Card> hand){
        int total = 0;
         for(int x = 0; x < hand.size(); x++){
             total += hand.get(x).cardValue;
         }
         return total;
    }

    private boolean dealerStand(){
        if(getValue(dealerHand) > 16){
            return true;
        }
        return false;
    }

    private void setAceValue(ArrayList<Card> hand) {
        for(Card c : hand) {
            if(c.cardValue == 11 && getValue(hand) > 21) c.cardValue = 1;
        }
    }
}
