package org.example;

public class Board {
    private final char[] cells;
    public Board() {
        cells = new char[9];
        reset();
    }

    public void reset() {
        for (int i = 0; i < 9; i++) {
            cells[i] = (char) ('1' + i); // 1..9 
        }
    }

    public boolean placeMark(int position, char mark) {
        if (position < 1 || position > 9) {
            return false;
        }
        int index = position - 1;
        if (cells[index] == 'X' || cells[index] == 'O') {
            return false;
        }
        cells[index] = mark;
        return true;
    }

    public boolean isFull() {
        for (char c : cells) {
            if (c != 'X' && c != 'O') {
                return false;
            }
        }
        return true;
    }

    public boolean hasWinner() {
        return getWinner() != ' ';
    }

    public char getWinner() {
        int[][] lines = {
            {0, 1, 2},
            {3, 4, 5},
            {6, 7, 8},
            {0, 3, 6},
            {1, 4, 7},
            {2, 5, 8},
            {0, 4, 8},
            {2, 4, 6}
        };

        for(int[] line : lines) { 
            char a = cells[line[0]];
            char b = cells[line[1]];
            char c = cells[line[2]];
            if (a == b && b == c && (a == 'X' || a == 'O')) {
                return a;
            }
        }
        return ' ';
    }

    public void printBoard() {
        System.out.println();
        System.out.printf("   %c  |  %c  |  %c%n", cells[0], cells[1], cells[2]);
        System.out.println("  ----+------+-----");
        System.out.printf("   %c  |  %c  |  %c%n", cells[3], cells[4], cells[5]);
        System.out.println("  ----+------+-----");
        System.out.printf("   %c  |  %c  |  %c%n", cells[6], cells[7], cells[8]);
        System.out.println();
    }

    public char[] getCells() {
        return cells;
    }
}