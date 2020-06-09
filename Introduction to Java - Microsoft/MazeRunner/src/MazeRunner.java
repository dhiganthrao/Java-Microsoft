//Program for a user to play a game traversing a maze. MAde by Dhiganth Rao for Final Project.
//V 1.0

import java.util.Scanner;
public class MazeRunner {
    Maze myMap = new Maze();

    public static void main (String[] args) {
        int moves = 0;
        Maze myMap = new Maze();
        intro(myMap);
        while (!myMap.didIWin()) {
            Move(myMap);
            myMap.printMap();
            moves += movesMessages(moves);
        }
        success(moves);

    }
    public static void intro(Maze myMap) {    //Introductory function
        System.out.println("Welcome to Maze Runner!");
        System.out.println("Here is your current position: ");
        myMap.printMap();

    }


    public static void Move (Maze myMap) { //Accepts a move as input and changes position based on input
        Scanner input = new Scanner(System.in);
        System.out.println("Where would you like to move? (R, L, U, D): ");
        String direction = input.next().toUpperCase();

        switch(direction) {
            case "R":
                if (myMap.canIMoveRight()) {
                    myMap.moveRight();
                    break;
                } else {
                    if (myMap.isThereAPit(direction)) {
                        navigatePit(myMap, direction);
                        break;
                    } else {
                        wall();
                        break;
                    }
                }
            case "L":
                if (myMap.canIMoveLeft()) {
                    myMap.moveLeft();
                    break;
                } else {
                    if (myMap.isThereAPit(direction)) {
                        navigatePit(myMap, direction);
                        break;
                    } else {
                        wall();
                        break;
                    }
                }
            case "U":
                if (myMap.canIMoveUp()) {
                    myMap.moveUp();
                    break;
                } {
                if (myMap.isThereAPit(direction)) {
                    navigatePit(myMap, direction);
                    break;
                } else {
                    wall();
                    break;
                }
            }

            case "D":
                if (myMap.canIMoveDown()) {
                    myMap.moveDown();
                    break;
                } else {
                    if (myMap.isThereAPit(direction)) {
                        navigatePit(myMap, direction);
                        break;
                    } else {
                        wall();
                        break;
                    }
                }

            default:
                System.out.println("Invalid entry. Try again.");
        }

    }

    public static void wall() { //notifies the user that they've hit a wall
        System.out.println("Sorry, you've hit a wall. Try again.");
    }

    public static void success(int moves) {  //executes only if person makes it out of the maze
        System.out.println("Congratulations, you made it out alive!");
        System.out.println("You completed the maze in " + moves + " moves.");
    }

    public static void navigatePit(Maze myMap, String dir) { //What to do if user encounters a pit
        System.out.println("Watch out! There's a pit ahead, jump it? (Y - yes, any other response - no)");
        Scanner input = new Scanner(System.in);
        String option = input.next().toUpperCase();

        if (option.equals("Y")) {
            myMap.jumpOverPit(dir);
        } else {
            System.out.println("Select another move.");
        }
    }

    public static int movesMessages(int moves) {
        //Returns number of moves currently passed and alerts when a certain number of moves have passed
        switch(moves) {

            case 50:
                System.out.println("Warning: You have made 50 moves, you have 50 remaining "
                        + "before the maze exit closes");
                break;
            case 75:
                System.out.println("Alert! You have made 75 moves, you only have 25 moves "
                        + "left to escape.");
                break;

            case 90:
                System.out.println("DANGER! You have made 90 moves, you only have 10 moves "
                        + "left to escape!!");
                break;

            case 100:
                System.out.println("Oh no! You took too long to escape, and now the maze "
                        + "exit is closed FOREVER >:[");
                System.exit(0);

            default:
                System.out.println("You have now made " + moves + " moves.");
        }
        return 1;
    }
}


