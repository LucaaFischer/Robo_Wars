package com.btcag.bootcamp;

import java.util.Scanner;

public class intro_restricted {
    public static void main(String[] args) {
        System.out.println("   ROBOT-WARS");
        System.out.println("      _____");
        System.out.println("     /     \\");
        System.out.println("    |  O O  |");
        System.out.println("    |   ^   |");
        System.out.println("     \\_____/");
        System.out.println("      || ||");
        System.out.println("      || ||");
        System.out.println();
        Scanner inputName = new Scanner(System.in);
        System.out.println("Bitte gib deinen gewünschten Benutzernamen ein");
        String username = inputName.nextLine();

        while (username.length() < 4 || username.length() > 16) {
            System.out.println("Der eingegebene Name ist unzulässig.");
            username = inputName.nextLine();
        }
        System.out.println("Willkommen zu ROBOT-WARS " + username + "!!!");
    }
}
