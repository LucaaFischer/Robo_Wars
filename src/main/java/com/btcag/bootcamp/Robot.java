package com.btcag.bootcamp;

import java.util.Scanner;

public class Robot {
    int x;
    int y;
    int hp = 1;
    int energy = 1;
    int damage = 1;
    int shield = 1;
    int range = 1;
    int aeo = 1;
    int accuracy = 1;
    int movement = 1;

    public Robot(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void getMove() {
        Scanner input = new Scanner(System.in);
        System.out.println("Wo möchtest du deinen Roboter platzieren? x-Koordinate:");
        this.x = input.nextInt();
        System.out.println("Und die Y-Koordinate?");
        this.y = input.nextInt();
    }
}
