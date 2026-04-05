package org.example;

import java.util.Scanner;

public class App {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Game game = new Game();

    System.out.println("Welcome to Tic-Tac-Toe");
    boolean playAgain = true;
    
    while (playAgain) {
      game.reset();
      game.getBoard().printBoard();
      while (!game.isGameOver()) {

        System.out.print(game.getTurnMessage() + " What is your move? ");
        String input = scanner.nextLine().trim();

        Integer move = parseMove(input);
        if (move == null || move < 1 || move > 9) {
          System.out.println();
          System.out.println("That is not a valid move! Try again.");
          System.out.println();
          continue;
        }

        if (!game.getBoard().placeMark(move, game.getCurrentPlayer())) {
          System.out.println();
          System.out.println("That is not a valid move! Try again.");
          continue;
        }

        game.getBoard().printBoard();
        if(!game.isGameOver()) {
          game.switchPlayer();
        }
      }

      char winner = game.getBoard().getWinner();
      if (winner == 'X' || winner == 'O') {
        System.out.println("Player " + winner + " wins!");
      } else {
        System.out.println("The game is a draw!");
      }
      System.out.println();
      playAgain = askPlayAgain(scanner);
    }
    System.out.println();
    System.out.println("Goodbye!");
    scanner.close();
  }

  private static Integer parseMove(String input) {
    if (input.isEmpty()) {
      return null;
    }
    if (!input.matches("\\d+")) {
      return null;
    } try {
      return Integer.parseInt(input);
    } catch (NumberFormatException e) {
      return null;
    }
  }

  private static boolean askPlayAgain(Scanner scanner) {
    while (true) {
      System.out.print("Play Again(Y/N)? ");
      String answer = scanner.nextLine().trim().toLowerCase();
      if (answer.equals("yes") || answer.equals("y")) {
        System.out.println();
        return true;
      } else if (answer.equals("no") || answer.equals("n")) {
        return false;
      } else {
        System.out.println();
        System.out.println("That is not a valid entry!");
        System.out.println();
      }
    }
  }
}