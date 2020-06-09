//OddsandEvens. Written for Project 2 by Dhiganth Rao
// V 1.0

import java.util.*;

public class OddsandEvens {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.println("Let´s play a game called \"Odds and Evens\"");
        System.out.print("What is your name? ");
        String name = console.nextLine();
        System.out.print("Hi " + name + ", which do you choose? (O)dds or (E)vens? ");
        String player = console.next();
        if (player.equalsIgnoreCase("O")) {
            System.out.println(name + " has picked odds! The computer will be evens.");
        } else {
            System.out.println(name + " has picked evens! The computer will be odds.");
        }
        System.out.println("----------------------------------------------------------");
        System.out.println();
        System.out.print("How many \"fingers\" do you put out? ");
        int fingers = console.nextInt();
        Random rand = new Random();
        int computer = rand.nextInt(6);
        System.out.println("The computer plays number " + computer + " \"fingers\".");
        System.out.println("----------------------------------------------------------");
        System.out.println();
        int sum = fingers + computer;
        System.out.println(fingers + " + " + computer + " = " + sum);
        boolean oddOrEven = sum % 2 == 0;
        if (oddOrEven) {
            System.out.println(sum + " is... even!");
            if (player.equalsIgnoreCase("O")) {
                System.out.println("That means the computer wins!");
            }
            else {
                System.out.println("That means " + name + " wins! :)");
            }
        }
        else  {
            System.out.println(sum + " is... odd!");
            if (player.equalsIgnoreCase("O")) {
                System.out.println("That means " + name + " wins! :)");
            }
            else {
                System.out.println("That means the computer wins!");
                System.out.println("----------------------------------------------------------");
            }
        }
    }
}






