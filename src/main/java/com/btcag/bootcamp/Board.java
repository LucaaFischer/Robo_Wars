package com.btcag.bootcamp;

public class Board {
    public static void main(String[] args) {
        int y = 0;
        int x = 0;
        while (y < 15) {
            x = 0;
            while (x < 15) {
                System.out.print(" |_   _| ");
                x++;
            }
            System.out.println();
            System.out.println();
            y++;
        }
    }
}