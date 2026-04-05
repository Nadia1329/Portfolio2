package org.example;

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
    try {
        
    }
}