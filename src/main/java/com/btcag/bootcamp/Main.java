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
        System.out.println("Bitte gib deinen gewünschten Benutzernamen ein");
        String username = input.nextLine();

        while (username.length() < 4 || username.length() > 16) {
            System.out.println("Der eingegebene Name ist unzulässig.");
            username = input.nextLine();
        }
        System.out.println("Willkommen zu ROBOT-WARS " + username + "!!!");


        //Avatarerstellung
        System.out.println("Wähle ein Zeichen als Avatar");
        String avatar = input.nextLine();

        while (avatar.length() > 1) {
            System.out.println("Dein Avatar darf nur ein Zeichen sein");
            System.out.println("Bitte gib erneut ein Zeichen als Avatar ein");
            avatar = input.nextLine();
        }
        System.out.println("Dein Avatar: " + avatar);


        //Spielbretterstellung und erste Positionierung des Roboters.
        int y = 1;
        int x = 1;
        int maxZuege = 0;

        while(maxZuege <= 100) {
            System.out.println("Wo möchtest du deinen Roboter platzieren? X-Koordinate");
            int roboX = input.nextInt();
            System.out.println("Und die Y-Koordinate?");
            int roboY = input.nextInt();

            while (y <= 15) {
                x = 1;
                while (x <= 15) {
                    if (x == roboX && y == roboY) {
                        System.out.print(" [ " + avatar + " ] ");
                    } else {
                        System.out.print(" [   ] ");
                    }
                    x++;
                }
                System.out.println();
                System.out.println();
                y++;
            }
            System.out.println("Dein Roboter befindet sich auf Feld x " + roboX + " y " + roboY + ".");
            maxZuege++;
        }
    }
}