package com.btcag.bootcamp;

public class Game {
    //---------------------------------------------------------------------------Startpositionen für die Roboter------------------------------------------------------------------
    public static int countTurns = 0;
    public static int tempRoboOneX = 1;
    public static int tempRoboOneY = 1;
    public static int tempRoboTwoX = 15;
    public static int tempRoboTwoY = 15;

    //----------------------------------------------------------------------------------Spielzüge--------------------------------------------------------------------------------------
    public static void turn(Robot robot1, Robot robot2, Player player1, Player player2) {
        do {
            if (countTurns % 2 == 0) {
                System.out.println(player1.playerName + " ist dran!");
                robot1.getMove();
                player1.skillPoints++;
            } else {
                System.out.println(player2.playerName + " ist dran!");
                robot2.getMove();
                player2.skillPoints++;
            }
        } while (!moveValid(robot1, robot2));

        if (checkFight(robot1, robot2)) {
            fight(robot1, robot2, player1, player2);
        }

        Board board = new Board();
        board.drawBoard(robot1, robot2, player1, player2);

        if (countTurns % 2 != 0) {
            System.out.println("Ende der Runde. Nutzt eure Skillpoints!");
            useSkillPoints(player1, player2, robot1, robot2);
        }
        tempRoboOneX = robot1.x;
        tempRoboOneY = robot1.y;
        tempRoboTwoX = robot2.x;
        tempRoboTwoY = robot2.y;
        countTurns++;
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

    //---------------------------------------------------------------------Skillpoints in Stats stecken----------------------------------------------------------------------------
    public static void useSkillPoints(Player player1, Player player2, Robot robot1, Robot robot2) {
        while (player1.skillPoints > 0) {
            System.out.println("Du hast noch " + player1.skillPoints + " Skillpoints, " + player1.playerName);
            robot1.setStats();
            player1.skillPoints--;
        }
        while (player2.skillPoints > 0) {
            System.out.println("Du hast noch " + player2.skillPoints + " Skillpoints, " + player2.playerName);
            robot2.setStats();
            player2.skillPoints--;
        }

    //---------------------------------------------------------------Ausgabe der aktuellen Statverteilung-----------------------------------------------------------------------
        System.out.println("Eure Stats: ");
        System.out.println("        " + player1.playerName + " (" + player1.playerAvatar + ")" + "               " +
                player2.playerName + " (" + player2.playerAvatar + ")");

        System.out.println("HP:        " + robot1.hp + "                     " + robot2.hp);
        System.out.println("Energy:    " + robot1.energy + "                     " + robot2.energy);
        System.out.println("DMG:       " + robot1.damage + "                     " + robot2.damage);
        System.out.println("Shield:    " + robot1.shield + "                     " + robot2.shield);
        System.out.println("Range:     " + robot1.range + "                     " + robot2.range);
        System.out.println("AOE:       " + robot1.aoe + "                     " + robot2.aoe);
        System.out.println("Accuracy:  " + robot1.accuracy + "                     " + robot2.accuracy);
        System.out.println("Movement:  " + robot1.movement + "                     " + robot2.movement);
    }

    //-----------------------------------------------------------------Prüfen ob es zum Kampf kommt----------------------------------------------------------------------------------
    public static boolean checkFight(Robot robot1, Robot robot2) {
        return (robot1.x == robot2.x && robot1.y == robot2.y);
    }

    //------------------------------------------------------------------------Kampfablauf--------------------------------------------------------------------------------------------
    public static void fight(Robot robot1, Robot robot2, Player player1, Player player2) {
        Board board = new Board();
        System.out.println("ES KOMMT ZU EINEM SPANNENDEN KAMPF DE LA ROBOTS");
        int tempRoboOneDmg = robot1.damage;
        int tempRoboTwoDmg = robot2.damage;

        tempRoboTwoDmg -= robot1.shield;
        tempRoboOneDmg -= robot2.shield;

        if (robot2.shield > robot1.damage) {
            robot2.shield -= robot1.damage;
        } else if (robot2.shield < robot1.damage) {
            robot2.shield = 0;
        }
        if (robot1.shield > robot2.damage) {
            robot1.shield -= robot2.damage;
        } else if (robot1.shield < robot2.damage) {
            robot1.shield = 0;
        }

        if (tempRoboOneDmg > 0) {
            robot2.hp -= tempRoboOneDmg;
        }
        if (tempRoboTwoDmg > 0) {
            robot1.hp -= tempRoboTwoDmg;
        }

        if (checkWin(robot1, robot2)) {
            checkWinner(robot1, robot2, player1, player2);
        } else {
            System.out.println("But no one won");
            robot1.x = robot1.x - 1;
            robot1.y = robot1.y - 1;
            robot2.x = robot2.x + 1;
            robot2.y = robot2.y + 1;
            board.drawBoard(robot1, robot2, player1, player2);
        }
    }

    //-------------------------------------------------------------------Überprüfen ob es einen Gewinner gibt--------------------------------------------------------------------
    public static boolean checkWin(Robot robot1, Robot robot2) {
        return robot1.hp <= 0 || robot2.hp <= 0;
    }

    //-----------------------------------------------------------------------Prüfen wer gewonnen hat-------------------------------------------------------------------------------
    public static String checkWinner(Robot robot1, Robot robot2, Player player1, Player player2) {
        String winner = "";
        if (robot1.hp <= 0) {
            winner = player2.playerName;
        } else if (robot2.hp <= 0) {
            winner = player1.playerName;
        }
        return winner;
    }
}

