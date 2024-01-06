package com.company;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        // write your code here
        System.out.println("Welcome to the House Always Wins casino");
        Player player = login();
        boolean hasExited = false;

        while(!hasExited) {
            if (getYesNoInput().equals("y")) {
                Game game = new Game(player);
                game.startGame();
            } else {
                System.out.println("Thank you for visiting.");
                hasExited = true;
            }
        }
    }
    public static String getYesNoInput() {
        System.out.println("Would you like to play a game? y: yes, n: no");
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine().toLowerCase();

        while(!s.equals("y") && !s.equals("n")){
            System.out.println("that is an invalid input, try again: ");
            s = scanner.nextLine().toLowerCase();
        }
        return s;
    }
    public static Player login() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please login");
        System.out.println("What is your name?");
        String name = scanner.nextLine();
        System.out.println("How much money would you like to upload into your account?");
        while (!scanner.hasNextInt()) {
            System.out.println("Invlaid input");
        }
        int bal = scanner.nextInt();
        scanner.nextLine();
        return(new Player(name, bal));
	// write your code here
    }
}