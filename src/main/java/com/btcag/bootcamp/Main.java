package com.btcag.bootcamp;

import java.util.Scanner;

public class Main {
    public static Scanner input = new Scanner(System.in);
    public static String playerOne = "";
    public static String playerTwo = "";
    public static String[] avatars = new String[2];

    public static void main(String[] args) {

        System.out.println(intro());

        System.out.println("WILLKOMMEN ZU ROBOT-WARS " + getPlayerOne().toUpperCase() + " UND " + getPlayerTwo().toUpperCase() + " !!!");

        System.out.println("Dein Avatar " + playerOne + ": " + getAvatars()[0]);

        System.out.println("Dein Avatar " + playerTwo + ": " + avatars[1]);

        board();
    }


    public static String intro() {
        String introString = ("Welcome to Robot Wars!!!\n" +
                "  _____\n" +
                " /     \\\n" +
                "|  O O  |\n" +
                "|   ^   |\n" +
                " \\_____/\n" +
                "  || ||\n" +
                "  || ||\n");

        return introString;
    }

    // Namenseingabe
    public static String getPlayerOne() {
        System.out.println("Bitte gib deinen gewünschten Benutzernamen ein, Spieler 1.");
        playerOne = input.nextLine();

        while (playerOne.length() < 4 || playerOne.length() > 16) {
            System.out.println("Der eingegebene Name ist unzulässig.");
            playerOne = input.nextLine();
        }
        return playerOne;
    }

    public static String getPlayerTwo() {
        System.out.println("Bitte gib deinen gewünschten Benutzernamen ein, Spieler 2.");
        playerTwo = input.nextLine();

        while (playerTwo.length() < 4 || playerTwo.length() > 16) {
            System.out.println("Der eingegebene Name ist unzulässig.");
            playerTwo = input.nextLine();
        }
        return playerTwo;
    }

    //Avatarerstellung
    public static String[] getAvatars() {
        System.out.println("Wähle ein Zeichen als Avatar, " + playerOne);
        avatars[0] = input.next();

        while (avatars[0].length() > 1) {
            System.out.println("Dein Avatar darf nur ein Zeichen sein");
            System.out.println("Bitte gib erneut ein Zeichen als Avatar ein");
            avatars[0] = input.nextLine();
        }

        System.out.println("Wähle ein Zeichen als Avatar, " + playerTwo);
        avatars[1] = input.nextLine();

        while (avatars[1].length() > 1) {
            System.out.println("Dein Avatar darf nur ein Zeichen sein");
            System.out.println("Bitte gib erneut ein Zeichen als Avatar ein");
            avatars[1] = input.nextLine();
        }
        return avatars;
    }

    //Spielbretterstellung und Positionierung des Roboters.
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
                System.out.println("Wo möchtest du deinen Roboter platzieren, " + playerOne + "? x-Koordinate:");
                roboOneX = input.nextInt();
                System.out.println("Und die Y-Koordinate?");
                roboOneY = input.nextInt();
            } else {
                System.out.println("Wo möchtest du deinen Roboter platzieren, " + playerTwo + "? x-Koordinate:");
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
            System.out.println(playerOne + "'s Roboter (" + avatars[0] + ") befindet sich auf Feld x " + roboOneX + " y " + roboOneY + ".");
            System.out.println(playerTwo + "'s Roboter (" + avatars[1] + ") befindet sich auf Feld x " + roboTwoX + " y " + roboTwoY + ".");
            maxZuege++;
        }
    }
}

