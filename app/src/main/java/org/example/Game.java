package org.example;

public class Game {
    private final Board board;
    private char currentPlayer;
    public Game() {
        this.board = new Board();
        this.currentPlayer = 'X';
    }

    public Board getBoard() {
        return board;
    }

    public char getCurrentPlayer() {
        return currentPlayer;
    }

    public void switchPlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }

    public boolean isGameOver() {
        return board.hasWinner() || board.isFull();
    }

    public void reset(char startingPlayer) {
        board.reset();
        currentPlayer = startingPlayer;
    }

    public void reset() {
        reset('X');
    }
    
    public String getTurnMessage() {
        return "Player " + currentPlayer + "'s turn.";
    }
    
}