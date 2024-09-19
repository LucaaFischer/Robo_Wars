package com.btcag.bootcamp;
import java.util.Scanner;

public class avatar {
    public static void main(String[] args) {
        Scanner input_avatar = new Scanner(System.in);
        System.out.println("Erstelle dir deinen Avatar mit ASCII-Zeichen");
        String avatar = input_avatar.nextLine();

        while(avatar.length() < 3 || avatar.length() > 8) {
            System.out.println("Avatar leider nicht zulässig :(");
            System.out.println("Erstelle dir erneut einen Avatar mit ASCII-Zeichen");
            avatar = input_avatar.nextLine();
        }
        System.out.println("Dein Avatar: " + avatar);
        System.out.println();
        System.out.println("Viel Spaß beim Spiel! :)");
    }
}
