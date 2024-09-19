package com.btcag.bootcamp;
import javax.swing.*;
import java.util.Scanner;

public class intro {
    public static void main(String[] args ) {
        Scanner inputName = new Scanner(System.in);
        System.out.println("Bitte gib deinen gewünschten Benutzernamen ein");
        String username = inputName.nextLine();

        while(username.length() <4 || username.length() >16) {
            System.out.println("Der eingegebene Name ist unzulässig.");
            username = inputName.nextLine();
        }
        System.out.println("Willkommen zu ROBOT-WARS " + username + "!!!");

        JButton startGame = new JButton("Spiel starten");
        startGame.setActionCommand("Start");
    }
}
