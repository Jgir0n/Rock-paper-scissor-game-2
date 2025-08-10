package hw3;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Hw3 {

    public static void main(String[] args) {
        String name;
        String myMoves;
        String computerMoves = "";
        int computerInt;
        int win = 0;
        int loss = 0;
        int tie = 0;
        int c;
        int answer;

        Scanner scan = new Scanner(System.in);
        Random generator = new Random();

        System.out.println("Please enter your name.");
        System.out.println();
        name = scan.nextLine();

        c = getValidInt(scan, "Do you want the computer or you " + name + " to go first? (1 for computer, 2 for human): ", 1, 2);

        while (c == 2) {
            System.out.println(name + " let's Play! Please Enter Rock, Paper, or Scissors: ");

            System.out.println();

            System.out.println("Enter Your Choice: ");

            myMoves = getValidMove(scan);

            computerInt = generator.nextInt(3) + 1;

            if (computerInt == 1)
                computerMoves = "ROCK";
            else if (computerInt == 2)
                computerMoves = "PAPER";
            else
                computerMoves = "SCISSORS";

            printResult(name, myMoves, computerMoves, win, loss, tie);

            // Update scores
            if (myMoves.equals(computerMoves)) {
                tie++;
            } else if (isUserWinner(myMoves, computerMoves)) {
                win++;
            } else {
                loss++;
            }

            System.out.println();
            System.out.println("Wins: " + win + " loss: " + loss + " ties: " + tie);
            System.out.println();
            System.out.println("******************************************************************************");
            System.out.println();
            System.out.println();
            answer = getValidInt(scan, "Do you want to play again? Enter 1 for yes or 2 for no: ", 1, 2);

            if (answer == 1) {
                continue;
            } else {
                System.exit(0);
            }
        }

        while (c == 1) {
            computerInt = generator.nextInt(3) + 1;
            if (computerInt == 1)
                computerMoves = "ROCK";
            else if (computerInt == 2)
                computerMoves = "PAPER";
            else
                computerMoves = "SCISSORS";

            System.out.println();
            System.out.println("Computer already made a choice.");
            System.out.println();

            System.out.println("Now, enter Your Choice. Please Enter Rock, Paper, or Scissors: ");
            myMoves = getValidMove(scan);

            printResult(name, myMoves, computerMoves, win, loss, tie);

            // Update scores
            if (myMoves.equals(computerMoves)) {
                tie++;
            } else if (isUserWinner(myMoves, computerMoves)) {
                win++;
            } else {
                loss++;
            }

            System.out.println();
            System.out.println("Wins: " + win + " loss: " + loss + " ties: " + tie);
            System.out.println();
            System.out.println("******************************************************************************");
            System.out.println();
            System.out.println();
            answer = getValidInt(scan, "Do you want to play again? Enter 1 for yes or 2 for no: ", 1, 2);

            if (answer == 1) {
                continue;
            } else {
                System.exit(0);
            }

        }
    }

    private static int getValidInt(Scanner scan, String prompt, int min, int max) {
        int value;
        while (true) {
            System.out.print(prompt);
            try {
                value = scan.nextInt();
                if (value >= min && value <= max) {
                    scan.nextLine(); // consume leftover newline
                    return value;
                } else {
                    System.out.println("Invalid input. Please enter a number between " + min + " and " + max + ".");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scan.nextLine(); // discard invalid input
            }
        }
    }

    private static String getValidMove(Scanner scan) {
        String move;
        while (true) {
            move = scan.next();
            move = move.toUpperCase();
            if (move.equals("ROCK") || move.equals("PAPER") || move.equals("SCISSORS")) {
                return move;
            } else {
                System.out.println("Invalid input. Please enter Rock, Paper, or Scissors again:");
            }
        }
    }

    private static boolean isUserWinner(String user, String comp) {
        return (user.equals("ROCK") && comp.equals("SCISSORS")) ||
                (user.equals("PAPER") && comp.equals("ROCK")) ||
                (user.equals("SCISSORS") && comp.equals("PAPER"));
    }

    private static void printResult(String name, String userMove, String compMove, int win, int loss, int tie) {
        if (userMove.equals(compMove)) {
            System.out.println("It's a tie! Computer's Choice was: " + compMove);
        } else if (isUserWinner(userMove, compMove)) {
            System.out.println(userMove + " beats " + compMove + ". " + name + " You win!! Computer's Choice was: " + compMove);
        } else {
            System.out.println(compMove + " beats " + userMove + ". " + name + " You lose!! Computer's Choice was: " + compMove);
        }
    }
}
