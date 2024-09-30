package com.btcag.bootcamp;

import java.util.Random;
import java.util.Scanner;

//---------------------------------------------------Deklaration von in unterschiedlichen Methoden gebrauchten Variablen---------------------------------------------------------------
public class Main {
    public static Scanner input = new Scanner(System.in);
    public static String[] players = getPlayers();
    public static String[] avatars = getAvatars();

    //Startpositionen für die Roboter
    public static int maxTurns = 0;
    public static int roboOneX = 1;
    public static int roboOneY = 1;
    public static int roboTwoX = 15;
    public static int roboTwoY = 15;
    public static int tempRoboOneX = 1;
    public static int tempRoboOneY = 1;
    public static int tempRoboTwoX = 15;
    public static int tempRoboTwoY = 15;

    //-------------------------------------------------------------------------Main-------------------------------------------------------------------------------------------------
    public static void main(String[] args) {
        String introString = intro();
        System.out.println(introString);

        System.out.println("WILLKOMMEN ZU ROBOT-WARS " + players[0].toUpperCase() + " UND " + players[1].toUpperCase() + " !!!");

        System.out.println("Dein Avatar " + players[0] + ": " + avatars[0]);

        System.out.println("Dein Avatar " + players[1] + ": " + avatars[1]);

        game();
    }

    //--------------------------------------------------------------------ASCII-Art Intro-------------------------------------------------------------------------------------
    public static String intro() {
        return (
                "  _____\n" +
                        " /     \\\n" +
                        "|  O O  |\n" +
                        "|   ^   |\n" +
                        " \\_____/\n" +
                        "  || ||\n" +
                        "  || ||\n");


    }

    // ---------------------------------------------------------------- Namenseingabe---------------------------------------------------------------------------------
    public static String[] getPlayers() {
        String[] players = new String[2];
        System.out.println("Bitte gib deinen gewünschten Benutzernamen ein, Spieler 1.");
        players[0] = input.nextLine();

        while (players[0].length() < 4 || players[0].length() > 16) {
            System.out.println("Der eingegebene Name ist unzulässig.");
            players[0] = input.nextLine();
        }

        System.out.println("Bitte gib deinen gewünschten Benutzernamen ein, Spieler 2.");
        players[1] = input.nextLine();

        while (players[1].length() < 4 || players[1].length() > 16) {
            System.out.println("Der eingegebene Name ist unzulässig.");
            players[1] = input.nextLine();
        }
        return players;
    }

    //------------------------------------------------------------------------Avatarerstellung--------------------------------------------------------------
    public static String[] getAvatars() {
        String[] avatars = new String[2];
        System.out.println("Wähle ein Zeichen als Avatar, " + players[0]);
        avatars[0] = input.nextLine();

        while (avatars[0].length() != 1) {
            System.out.println("Dein Avatar muss ein Zeichen lang sein");
            System.out.println("Bitte gib erneut einen Avatar ein");
            avatars[0] = input.nextLine();
        }

        System.out.println("Wähle ein Zeichen als Avatar, " + players[1]);
        avatars[1] = input.nextLine();

        while (avatars[1].length() != 1) {
            System.out.println("Dein Avatar muss ein Zeichen  lang sein");
            System.out.println("Bitte gib erneut einen Avatar ein");
            avatars[1] = input.nextLine();
        }
        return avatars;
    }

    //----------------------------------------------------------------------------------------Game--------------------------------------------------------------------------------------
    public static void game() {
        int y = 1;
        int x = 1;

        while (maxTurns <= 100) {
            if (maxTurns > 1) {
                if (maxTurns % 2 == 0) {
                    System.out.println("Wo möchtest du deinen Roboter platzieren, " + players[0] + "? x-Koordinate:");
                    roboOneX = input.nextInt();
                    System.out.println("Und die Y-Koordinate?");
                    roboOneY = input.nextInt();

                } else {
                    System.out.println("Wo möchtest du deinen Roboter platzieren, " + players[1] + "? x-Koordinate:");
                    roboTwoX = input.nextInt();
                    System.out.println("Und die Y-Koordinate?");
                    roboTwoY = input.nextInt();
                }
            }
            moveValid();
            tempRoboOneX = roboOneX;
            tempRoboOneY = roboOneY;
            tempRoboTwoX = roboTwoX;
            tempRoboTwoY = roboTwoY;

            board();
        }
    }

    //-----------------------------------------------------------Überprüfung auf Möglichkeit des Zuges-------------------------------------------------------------------------
    public static void moveValid() {
        if (roboOneX > 15 || roboOneY > 15 || roboOneX < 1 || roboOneY < 1|| roboOneX > tempRoboOneX + 1 || roboOneY > tempRoboOneY + 1 || roboOneX < tempRoboOneX - 1 || roboOneY < tempRoboOneY - 1) {
            System.out.println("Der gewünschte Zug ist ungültig. Bitte nochmal ziehen.");
            System.out.println("Wo möchtest du deinen Roboter platzieren, " + players[0] + "? x-Koordinate:");
            roboOneX = input.nextInt();
            System.out.println("Und die Y-Koordinate?");
            roboOneY = input.nextInt();
            moveValid();
        } else if (roboTwoX > 15 || roboTwoY > 15 || roboTwoX < 1 || roboTwoY < 1 || roboTwoX > tempRoboTwoX + 1 || roboTwoY > tempRoboTwoY + 1 || roboTwoX < tempRoboTwoX - 1 || roboTwoY < tempRoboTwoY - 1) {
            System.out.println("Der gewünschte Zug ist ungültig. Bitte nochmal ziehen.");
            System.out.println("Wo möchtest du deinen Roboter platzieren, " + players[1] + "? x-Koordinate:");
            roboTwoX = input.nextInt();
            System.out.println("Und die Y-Koordinate?");
            roboTwoY = input.nextInt();
            moveValid();
        }
    }

    //----------------------------------------------------------------Zufälligen Gewinner bestimmen-------------------------------------------------------------------------
    public static String fight_randWinner() {
        String winner = "";
        if (roboOneX == roboTwoX && roboOneY == roboTwoY) {
            Random random = new Random();
            int randWinner = random.nextInt(0, 2);
            if (randWinner == 0) {
                winner = players[0];
            } else {
                winner = players[1];
            }
        }
        return winner;
    }

    //-------------------------------------------------------------Spielfelderstellung------------------------------------------------------------------------------------------
    public static void board() {
        int y = 1;
        int x = 1;
        while (y <= 15) {
            x = 1;
            while (x <= 15) {
                if (x == roboOneX && y == roboOneY) {
                    System.out.print(" [ " + avatars[0] + " ] ");
                } else if (x == roboTwoX && y == roboTwoY) {
                    System.out.print(" [ " + avatars[1] + " ] ");
                } else {
                    System.out.print(" [   ] ");
                }
                x++;
            }
            System.out.println();
            System.out.println();
            y++;
        }
        if (roboOneX == roboTwoX && roboOneY == roboTwoY) {
            System.out.println("AND THE WINNER ISSSSS " + fight_randWinner().toUpperCase());
        } else {
            System.out.println(players[0] + "'s Roboter (" + avatars[0] + ") befindet sich auf Feld x " + roboOneX + " y " + roboOneY + ".");
            System.out.println(players[1] + "'s Roboter (" + avatars[1] + ") befindet sich auf Feld x " + roboTwoX + " y " + roboTwoY + ".");
            maxTurns++;
        }
    }
}


