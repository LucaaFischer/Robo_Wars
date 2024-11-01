package com.btcag.bootcamp;

public class Board {
    public void drawBoard(Robot robot1, Robot robot2, Player player1, Player player2) {
        int y = 1;
        int x = 1;
        while (y <= 15) {
            x = 1;
            while (x <= 15) {
                if (x == robot1.x && y == robot1.y) {
                    System.out.print(" [ " + player1.playerAvatar + " ] ");
                } else if (x == robot2.x && y == robot2.y) {
                    System.out.print(" [ " + player2.playerAvatar + " ]");
                } else {
                    System.out.print(" [   ] ");
                }
                x++;
            }
            System.out.println();
            System.out.println();
            y++;
        }
        System.out.println(player1.playerName + "'s Roboter (" + player1.playerAvatar + ") befindet sich auf Feld x " + robot1.x + " y " + robot1.y + ".");
        System.out.println(player2.playerName + "'s Roboter (" + player2.playerAvatar + ") befindet sich auf Feld x " + robot2.x + " y " + robot2.y + ".");
    }
}
