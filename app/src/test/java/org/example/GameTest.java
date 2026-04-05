package org.example;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    
    @Test
    void testInitialPlayerisX() {
        Game game = new Game();
        assertEquals('X', game.getCurrentPlayer());
    }

    @Test
    void testSwitchPlayerChangesXtoO() {
        Game game = new Game();
        game.switchPlayer();
        assertEquals('O', game.getCurrentPlayer());
    }

    @Test
    void testSwitchPlayerChangesOtoX() {
        Game game = new Game();
        game.switchPlayer();
        assertEquals('O', game.getCurrentPlayer());
    }

    @Test
    void testIsGameOverTrueWhenWinner() {
        Game game = new Game();
        game.getBoard().placeMark(1, 'X');
        game.getBoard().placeMark(2, 'X');
        game.getBoard().placeMark(3, 'X');
        assertTrue(game.isGameOver());

    }

    @Test
    void testIsGameOverTrueWhenBoardFull() {
        Game game = new Game();
        for (int i = 1; i <= 9; i++) {
            game.getBoard().placeMark(i, 'X');
        }

        assertTrue(game.isGameOver());
    }

    @Test
    void testIsGameOverFalseAtStart() {
        Game game = new Game();
        assertFalse(game.isGameOver());
    }

    @Test
    void testResetRestoreBoardAndPlayer() {
        Game game = new Game();
        game.getBoard().placeMark(1, 'X');
        game.switchPlayer();
        game.reset();
        assertEquals('X', game.getCurrentPlayer());
        assertEquals('1', game.getBoard().getCells()[0]);
    }


}