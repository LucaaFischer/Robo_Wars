package com.btcag.bootcamp;

import java.util.Random;

public class Game {
    //Startpositionen für die Roboter
    public static int countTurns = 0;
    public static int tempRoboOneX = 1;
    public static int tempRoboOneY = 1;
    public static int tempRoboTwoX = 15;
    public static int tempRoboTwoY = 15;

    //----------------------------------------------------------------------------------------Game--------------------------------------------------------------------------------------
    public static void turn(Robot robot1, Robot robot2, Player player1, Player player2) {
        while (!checkWin(robot1, robot2)) {
            do {
                if (countTurns % 2 == 0) {
                    System.out.println(player1.playerName + " ist dran!");
                    robot1.getMove();
                } else {
                    System.out.println(player2.playerName + " ist dran!");
                    robot2.getMove();
                }
            } while (!moveValid(robot1, robot2));

            tempRoboOneX = robot1.x;
            tempRoboOneY = robot1.y;
            tempRoboTwoX = robot2.x;
            tempRoboTwoY = robot2.y;
            countTurns++;
            Board board = new Board();
            board.drawBoard(robot1, robot2, player1, player2);
        }
        System.out.println("AND THE WINNER ISSSSS " + fight_randWinner(robot1, robot2, player1, player2).toUpperCase());
    }

    //------------------------------------------------------------------------------Prüfen ob es Gewinner gibt----------------------------------------------------------------------------------
    public static boolean checkWin(Robot robot1, Robot robot2) {
        return (robot1.x == robot2.x && robot1.y == robot2.y);
    }

    //---------------------------------------------------------------------Zufälligen Gewinner bestimmen----------------------------------------------------------------------------------
    public static String fight_randWinner(Robot robot1, Robot robot2, Player player1, Player player2) {
        String winner = "";
        if (checkWin(robot1, robot2)) {
            Random random = new Random();
            int randWinner = random.nextInt(0, 2);

            if (randWinner == 1) {
                winner = player1.playerName;
            } else {
                winner = player2.playerName;
            }
        }
        return winner;
    }

    //----------------------------------------------------------------Überprüfung auf Möglichkeit des Zuges------------------------------------------------------------------------------
    public static boolean moveValid(Robot robot1, Robot robot2) {
        if (robot1.x > 15 || robot1.y > 15 || robot1.x < 1 || robot1.y < 1 || robot2.x > 15 || robot2.y > 15 || robot2.x < 1 || robot2.y < 1) {
            System.out.println("Zug außerhalb des Spielfelds! Mach nochmal.");
            return false;
        } else if (robot1.x > tempRoboOneX + 1 || robot1.y > tempRoboOneY + 1 || robot1.x < tempRoboOneX - 1 || robot1.y < tempRoboOneY - 1
                || robot2.x > tempRoboTwoX + 1 || robot2.y > tempRoboTwoY + 1 || robot2.x < tempRoboTwoX - 1 || robot2.y < tempRoboTwoY - 1) {
            System.out.println("Zug nicht möglich! Mach nochmal.");
            return false;
        } else {
            return true;
        }
    }
}
