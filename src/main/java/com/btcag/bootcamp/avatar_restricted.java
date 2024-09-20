package com.btcag.bootcamp;

import java.util.Scanner;

public class avatar_restricted {
    public static void main(String[] args) {
        Scanner input_avatar = new Scanner(System.in);
        System.out.println("Wähle ein Zeichen als Avatar");
        String avatar = input_avatar.nextLine();

        while(avatar.length() > 1) {
            System.out.println("Dein Avatar darf nur ein Zeichen sein");
            System.out.println("Bitte gib erneut ein Zeichen als Avatar ein");
            avatar = input_avatar.nextLine();
        }
        System.out.println("Dein Avatar: " + avatar);
    }
}
