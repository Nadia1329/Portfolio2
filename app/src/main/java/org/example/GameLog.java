package org.example;
import java.io.PrintWriter;
import java.io.IOException;


public class GameLog {
    private int xWins;
    private int oWins;
    private int ties;
    public GameLog() {
        xWins = 0;
        oWins = 0;
        ties = 0;
    }

    public void recordResult(char winner) {
        if (winner == 'X') {
         xWins++;
     } else if (winner == 'O') {
          oWins++;
        } else {
          ties++;
     }
    }

    public void recordTie() {
        ties++;
    }

    public void printLog() {
      System.out.println("Game Log:");
     System.out.println("X Wins: " + xWins);
     System.out.println("O Wins: " + oWins);
     System.out.println("Ties: " + ties);
     System.out.println();
    }

    public void saveToFile() {
     try (PrintWriter out = new PrintWriter("game_log.txt")) {
        out.println("Game Log:");
        out.println("X Wins: " + xWins);
        out.println("O Wins: " + oWins);
        out.println("Ties: " + ties);
        } catch (IOException e) {
        System.out.println("Error saving game log: " + e.getMessage());
        
        }
    }
}