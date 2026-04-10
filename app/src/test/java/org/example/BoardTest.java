package org.example;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    @Test
    void testResetInitializesCellsTo1Through9() {
        Board board = new Board();
        for (int i = 0; i < 9; i++) {
            assertEquals((char) ('1' + i), board.getCells()[i]);
        }
    }

    @Test
    void testPlaceMarkValidMove() {
        Board board = new Board();
        assertTrue(board.placeMark(1, 'X'));
        assertEquals('X', board.getCells()[0]);
    }

    @Test
    void testPlaceMarkInvaldPositionLow() {
        Board board = new Board();
        assertFalse(board.placeMark(0, 'X'));
    }

    @Test
    void testPlaceMarkInvalidPositionHigh() {
        Board board = new Board();
        assertFalse(board.placeMark(10, 'X'));
    }

    @Test
    void testPlaceMarkOnOccupiedCellFails() {
        Board board = new Board();
        board.placeMark(1, 'O');
        assertFalse(board.placeMark(1, 'X'));
    } 
    
    @Test
    void testIsFullFalseWhenEmpty() {
        Board board = new Board();
        for (int i = 1; i <= 9; i++) {
            board.placeMark(i, 'X');
        }
        assertTrue(board.isFull());
    }

    @Test
    void testGetWinnerReturnsXForWinningRow() { 
        Board board = new Board();
        board.placeMark(1, 'X');
        board.placeMark(2, 'X');
        board.placeMark(3, 'X');
        assertEquals('X', board.getWinner());
    }

    @Test
    void testGetWinnerReturnsSpaceWhenNoWinner() {
        Board board = new Board();
        assertEquals(' ', board.getWinner());
    }

    @Test
    void testHasWinnerTrue() { 
        Board board = new Board();
        board.placeMark(1, 'X');
        board.placeMark(2, 'X');
        board.placeMark(3, 'X');
        assertTrue(board.hasWinner());
    }

    @Test
    void testHasWinnerFalse() {
        Board board = new Board();
        assertFalse(board.hasWinner());
    }

    @Test
    void testResetRestoresNumbers(){
      Board board = new Board();
      board.placeMark(1, 'X');
      board.reset();
      assertEquals('1', board.getCells()[0]);
    }
}