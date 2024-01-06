package com.company;

public class Player {
    public int balance = 0;
    public String name;

    public Player(String name, int balance){
        this.balance = balance;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getBalance(){
        return balance;
    }
}
