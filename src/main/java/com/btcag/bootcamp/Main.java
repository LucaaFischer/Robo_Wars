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
        Scanner inputName = new Scanner(System.in);
        System.out.println("Bitte gib deinen gewünschten Benutzernamen ein");
        String username = inputName.nextLine();

        while (username.length() < 4 || username.length() > 16) {
            System.out.println("Der eingegebene Name ist unzulässig.");
            username = inputName.nextLine();
        }
        System.out.println("Willkommen zu ROBOT-WARS " + username + "!!!");


        //Avatarerstellung
        Scanner input_avatar = new Scanner(System.in);
        System.out.println("Wähle ein Zeichen als Avatar");
        String avatar = input_avatar.nextLine();

        while(avatar.length() > 1) {
            System.out.println("Dein Avatar darf nur ein Zeichen sein");
            System.out.println("Bitte gib erneut ein Zeichen als Avatar ein");
            avatar = input_avatar.nextLine();
        }
        System.out.println("Dein Avatar: " + avatar);


        //Spielbretterstellung und erste Positionierung des Roboters.
        int y = 0;
        int x = 0;
        int roboty = 7;
        int robotx = 9;

        while (y < 15) {
            x = 0;
            while (x < 15) {
                if (x == robotx && y == roboty) {
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
    }
}