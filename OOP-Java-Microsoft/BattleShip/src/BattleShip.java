//BattleShip, a project created for Project 1. By Dhiganth Rao.
//V 1.0

import java.util.*;

public class BattleShip {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to BattleShips! The aim of the game is to try and sink your opponents' ships.");
        String[][] OceanMap = new String[10][10];
        String[][] OceanMapPlayer = new String[10][10];
        DisplayMap(OceanMap);
        System.out.println("Player: Enter the position where you want your ships to be.");
        int i , j;
        for(i = 0; i< 5; i++) {
            int x , y;
            x = xCoordinate();
            y = yCoordinate(x, OceanMap);
            OceanMap[x][y] = "@";
            OceanMapPlayer[x][y] = "@";
        }
        System.out.println("All right! You've successfully placed your ships.");
        DisplayMap(OceanMap);
        System.out.println("Waiting for the computer to deploy ships...");
        for(i = 0; i < 5; i++) {
            OceanMap = ComputerShips(OceanMap);

            System.out.println("Ship " + (i + 1) + " deployed!");
        }

        System.out.println("The computer has successfully deployed its ships.");
        System.out.println("It is time for you to do battle with the computer!\n Who will be the first to emerge victorious?");
        int result;
        result = Battle(OceanMap, OceanMapPlayer);
        if(result == 0) {
            System.out.println("You have lost :[ The computer managed to sink your ships before you did!");
        }
        else System.out.println("You have won! You managed to sink the computer's ships in time! ");

    }

    public static int Battle(String[][] OceanMap, String[][] OceanMapPlayer) { //Function implementing Battle between Player and Computer
        int Player , Computer , x , flag_p, flag_c;
        Player = 5;
        Computer = 5;
        while(Player != 0 && Computer != 0) {
            System.out.println("Your turn!");

            flag_p = PlayerMove(OceanMap, OceanMapPlayer);
            if (flag_p == 0) {
                Player--;
            }

            else if (flag_p == 1) {
                Computer--;
            }

            else if (flag_p == 2) {
                System.out.println("Test");
            }

            System.out.println("Here is the current ocean map.");
            //DisplayMap(OceanMapPlayer);
            System.out.println("Computer's turn!");
            flag_c = ComputerMove(OceanMap, OceanMapPlayer);

            if(flag_c == 2) {
                Player--;
            }

            else if(flag_c == 1) {
                Computer--;
            }

            System.out.println("Here is the current ocean map.");
            DisplayMap(OceanMapPlayer);
            System.out.println("You now have " + Player + " ships." );
            System.out.println("Computer now has " + Computer + " ships." );
        }

        if (Player == 0) {
            return 0;
        }

        else return 1;
        }


    public static void DisplayMap(String[][]OceanMap) { //Function to display a map of where the Player's ships are
        System.out.println("Here is the current ocean map (Your ships only): ");
        int row , col;
        System.out.println("  0123456789");
        for(row = 0 ; row < OceanMap.length; row++) {
            System.out.print(row + "|");
            for (col = 0; col < OceanMap[row].length; col++) {
                if(OceanMap[row][col] == null) {
                    System.out.print(" ");
                }
                else {
                    System.out.print(OceanMap[row][col]);
                }
            }
            System.out.println("|" + row);
        }
        System.out.println("  0123456789");
    }

    public static String[][] ComputerShips(String[][]OceanMap) { //Function to randomly select ships to place for Computer
        int x = xRandom();
        int y = yRandom();
        if(OceanMap[x][y] == null) {
            OceanMap[x][y] = "*";
        }
        else {
            OceanMap = ComputerShips(OceanMap);
        }
        return OceanMap;
    }

    public static int xCoordinate() { //Function to accept x-coordinate from Player
        Scanner input = new Scanner(System.in);
        int x;
        System.out.print("Enter an x coordinate: ");
        x = input.nextInt();
        if(x > 9) {
            System.out.println("You have entered a coordinate greater than 9. Please enter another coordinate.");
            x = xCoordinate();
        }
        return x;
    }

    public static int yCoordinate(int x, String[][]OceanMap) { //Function to accept y-coordinate from Player
        Scanner input = new Scanner(System.in);
        int y;
        System.out.print("Enter a y coordinate: ");
        y = input.nextInt();
        if(y > 9) {
            System.out.println("You have entered a coordinate greater than 9. Please enter another coordinate.");
            y = yCoordinate(x, OceanMap);
        }
        else if(OceanMap[x][y] != null) {
            System.out.println("There is already a ship here! Enter another Y coordinate");
            y = yCoordinate(x, OceanMap);
        }
        return y;

    }

    public static int ComputerMove(String[][]OceanMap, String[][] OceanMapPlayer) {
        //Random coordinate = new Random();
        int[][] MoveMatrix = new int[10][10];
        int x = xRandom();
        int y = yRandom();
        while(MoveMatrix[x][y] == 1) {
            x = xRandom();
            y = yRandom();
        }
        int flag;
        if(OceanMap[x][y] == "@") {
            System.out.println("Computer destroyed one of your ships! At coordinates: (" + x + ", " + y + ")!");
            OceanMap[x][y] = "x";
            OceanMapPlayer[x][y] = "x";
            flag = 2;
        }
        else if (OceanMap[x][y] == "*") {
            System.out.println("Computer destroyed one of its ships!");
            OceanMap[x][y] = "!";
            flag = 1;
        }
        else {
            System.out.println("Computer missed!");
            MoveMatrix[x][y] = 1;
            OceanMap[x][y] = "c";
            flag =  0;
        }
        return flag;
    }

    public static int xRandom()  { //Setting random x-coordinate values
        Random coordinate = new Random();
        int x = coordinate.nextInt(10);
        return x;

    }

    public static int yRandom()  { //Setting random y-coordinate values
        Random coordinate = new Random();
        int y = coordinate.nextInt(10);
        return y;

    }

    public static int PlayerMove(String[][]OceanMap, String[][] OceanMapPlayer) {
        Scanner input = new Scanner(System.in);
        int x = xCoordinate();
        int flag = 0;
        System.out.print("Enter a y coordinate: ");
        flag = input.nextInt();
        if(flag > 9) {
            System.out.println("You have entered a coordinate greater than 9. Please enter another coordinate.");
            flag = yCoordinate(x, OceanMap);
        }
        else if(OceanMap[x][flag] == "@") {
            System.out.println("You sunk your own ship!");
            OceanMap[x][flag] = "x";
            OceanMapPlayer[x][flag] = "x";
            flag = 0;
        }
        else if(OceanMap[x][flag] == "*") {
            System.out.println("You sunk a computer's ship!");
            OceanMap[x][flag] = "!";
            OceanMapPlayer[x][flag] = "!";
            flag = 1;
        }
        else if(OceanMap[x][flag] == null) {
            System.out.println("You missed!");
            OceanMap[x][flag] = "p";
            OceanMapPlayer[x][flag] = "p";
            //MoveMatrix[x][flag] = 1;
            flag = 2;
        }
        else if(OceanMap[x][flag] == "p" || OceanMap[x][flag] == "!" || OceanMap[x][flag] == "x") {
            System.out.println("You have entered the same coordinates! Please choose another set.");
            flag = PlayerMove(OceanMap, OceanMapPlayer);
        }
        return flag;
    }

}
