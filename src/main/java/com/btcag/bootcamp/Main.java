package com.btcag.bootcamp;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Intro

        System.out.println("Welcome to Robot Wars!!!");
        System.out.println("      _____");
        System.out.println("     /     \\");
        System.out.println("    |  O O  |");
        System.out.println("    |   ^   |");
        System.out.println("     \\_____/");
        System.out.println("      || ||");
        System.out.println("      || ||");
        System.out.println();


        // Namenseingabe
        Scanner input = new Scanner(System.in);
        System.out.println("Bitte gib deinen gewünschten Benutzernamen ein, Spieler 1.");
        String playerOne = input.nextLine();

        while (playerOne.length() < 4 || playerOne.length() > 16) {
            System.out.println("Der eingegebene Name ist unzulässig.");
            playerOne = input.nextLine();
        }

        System.out.println("Bitte gib deinen gewünschten Benutzernamen ein, Spieler 2.");
        String playerTwo = input.nextLine();

        while (playerTwo.length() < 4 || playerTwo.length() > 16) {
            System.out.println("Der eingegebene Name ist unzulässig.");
            playerTwo = input.nextLine();
        }

        System.out.println("WILLKOMMEN ZU ROBOT-WARS " + playerOne.toUpperCase() + " UND " + playerTwo.toUpperCase() + " !!!");


        //Avatarerstellung
        System.out.println("Wähle ein Zeichen als Avatar, " + playerOne);
        String avatarPlayerOne = input.nextLine();

        while (avatarPlayerOne.length() > 1) {
            System.out.println("Dein Avatar darf nur ein Zeichen sein");
            System.out.println("Bitte gib erneut ein Zeichen als Avatar ein");
            avatarPlayerOne = input.nextLine();
        }

        System.out.println("Wähle ein Zeichen als Avatar, " + playerTwo);
        String avatarPlayerTwo = input.nextLine();

        while (avatarPlayerTwo.length() > 1) {
            System.out.println("Dein Avatar darf nur ein Zeichen sein");
            System.out.println("Bitte gib erneut ein Zeichen als Avatar ein");
            avatarPlayerTwo = input.nextLine();
        }

        System.out.println("Dein Avatar " + playerOne + ": " + avatarPlayerOne);
        System.out.println("Dein Avatar " + playerTwo + ": " + avatarPlayerTwo);


        //Spielbretterstellung und Positionierung des Roboters.
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
                            System.out.print(" [ " + avatarPlayerOne + " ] ");
                        } else if (x == roboTwoX && y == roboTwoY) {
                            System.out.print(" [ " + avatarPlayerTwo + " ] ");
                        } else {
                            System.out.print(" [   ] ");
                        }
                        x++;
                    }
                System.out.println();
                System.out.println();
                y++;
            }
            System.out.println(playerOne + "'s Roboter (" + avatarPlayerOne + ") befindet sich auf Feld x " + roboOneX + " y " + roboOneY + ".");
            System.out.println(playerTwo + "'s Roboter (" + avatarPlayerTwo + ") befindet sich auf Feld x " + roboTwoX + " y " + roboTwoY + ".");
            maxZuege++;
        }
    }
}