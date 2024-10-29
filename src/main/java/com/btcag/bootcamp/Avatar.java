package com.btcag.bootcamp;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class avatar {
    public static void main(String[] args) {
        Scanner input_avatar = new Scanner(System.in);
        System.out.println("Wähle einen Avatar. 1, 2 oder 3");
        int avatar = input_avatar.nextInt();

        String[] robo1 = {
                "  _____  ",
                " /     \\ ",
                " | () ()|",
                " \\  ^  / ",
                "  ||||| ",
                "  ||||| "
        };

        String[] robo2 = {
                "   ____ ",
                " /     \\  ",
                "|  O O  | ",
                "|   ^   |",
                " \\_____/ ",
                "  || ||  ",
                "  || ||  "
        };

        String[] robo3 = {
                "   _____   ",
                "  /    \\ ",
                " |  @ @  | ",
                " |   ~   | ",
                "  \\_____/  ",
                "    || ||    ",
                "    || ||    ",
        };

        System.out.println("Dein Avatar: ");
        int i = 0;
        if(avatar == 1) {
            while (i < robo1.length) {
                System.out.println(robo1[i]);
                i++;
            };
        } else if (avatar == 2) {
            while (i < robo2.length) {
                System.out.println(robo2[i]);
                i++;
            }
        } else if(avatar == 3) {
            while (i < robo3.length) {
                System.out.println(robo3[i]);
                i++;
            }
        }
        System.out.println();
        System.out.println("Viel Spaß beim Spiel! :)");
    }
}
