package com.example.anil6066.blackjack;

public class BlackJack {
    public static final int SIDE = 4;
    public static int count =0;
    public static int value =0;

    public int getRandValue()
    {
        return  (int)(Math.random()*11)+1;
    }
}
