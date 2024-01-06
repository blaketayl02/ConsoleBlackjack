package com.company;

import java.util.Scanner;

public class Game {
    public String name;
    protected Player player;
    public int betamount;



    public Game(Player p){
        player = p;
    }



    public void startGame() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Which game would you like to play?" + " b = blackjack");
        if (scanner.nextLine().equals(("b"))) {
            Blackjack blackjack = new Blackjack(player);
            blackjack.startGame();
        }
        System.out.println("Your new balance is: " + player.balance);
    }
    protected void getBetAmount() {
        Scanner scanner = new Scanner(System.in);
        boolean isBetValid = false;
        System.out.println("What is your bet amount?");
        while(!isBetValid) {
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input, try again");
            }
            betamount = scanner.nextInt();
            scanner.nextLine();
            if (betamount > player.balance) {
                System.out.println("Invalid input, try again");
                continue;
            }
            isBetValid = true;
        }
    }
}
