package com.btcag.bootcamp;

import java.util.Scanner;

public class Main {
    public static Scanner input = new Scanner(System.in);
    public static String[] players = getPlayers();
    public static String[] avatars = getAvatars();

    public static void main(String[] args) {
        String introString = intro();
        System.out.println(introString);

        System.out.println("WILLKOMMEN ZU ROBOT-WARS " + players[0].toUpperCase() + " UND " + players[1].toUpperCase() + " !!!");

        System.out.println("Dein Avatar " + players[0] + ": " + avatars[0]);

        System.out.println("Dein Avatar " + players[1] + ": " + avatars[1]);

        board();
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

    //----------------------------------------------------------Spielbretterstellung und Positionierung des Roboters.-----------------------------------------------------
    public static void board() {
        int y = 1;
        int x = 1;
        int maxZuege = 0;
        int roboOneX = 0;
        int roboOneY = 0;
        int roboTwoX = 0;
        int roboTwoY = 0;

        while (maxZuege <= 100) {
            if (maxZuege % 2 == 0) {
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
            y = 0;
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
            System.out.println(players[0] + "'s Roboter (" + avatars[0] + ") befindet sich auf Feld x " + roboOneX + " y " + roboOneY + ".");
            System.out.println(players[1] + "'s Roboter (" + avatars[1] + ") befindet sich auf Feld x " + roboTwoX + " y " + roboTwoY + ".");
            maxZuege++;
        }
    }
}

