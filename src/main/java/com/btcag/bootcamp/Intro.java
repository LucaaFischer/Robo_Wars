package com.btcag.bootcamp;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

public class intro {
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

        JFrame startWindow = new JFrame("start Game");
        startWindow.setSize(300, 200);
        JButton startButton = new JButton("Spiel starten");
        startButton.setBounds(100, 80, 120, 30);

        startWindow.add(startButton);
        startWindow.setVisible(true);
    }
}
