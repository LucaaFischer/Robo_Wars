package com.btcag.bootcamp;

//---------------------------------------------------Deklaration von in unterschiedlichen Methoden gebrauchten Variablen---------------------------------------------------------------
public class Main {
    //-------------------------------------------------------------------------Main-------------------------------------------------------------------------------------------------
    public static void main(String[] args) {
        Player player1 = new Player();
        Player player2 = new Player();
        Robot robot1 = new Robot(1, 1);
        Robot robot2 = new Robot(15, 15);

        System.out.println("Spieler 1: ");
        player1.getName();
        player1.getAvatars();
        System.out.println();
        System.out.println("Spieler 2: ");
        player2.getName();
        player2.getAvatars();

        System.out.println("WILLKOMMEN ZU ROBOT-WARS " + player1.playerName.toUpperCase() + " UND " + player2.playerName.toUpperCase() + " !!!");
        System.out.println("Dein Avatar " + player1.playerName + ": " + player1.playerAvatar);
        System.out.println("Dein Avatar " + player2.playerName + ": " + player2.playerAvatar);

        Game.turn(robot1, robot2, player1, player2);
    }
}


