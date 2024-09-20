package com.btcag.bootcamp;

public class board_restricted {
    public static void main(String[] args) {
        int y = 0;
        int x = 0;
        int roboty = 7;
        int robotx = 9;

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
