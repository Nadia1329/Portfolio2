package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.File;

class GameLogTest {

    @Test
    void recordResult_updatesWinCountsCorrectly() {
        GameLog log = new GameLog();

        log.recordResult('X');
        log.recordResult('O');
        log.recordResult('X');
        log.recordResult('T');

        assertEquals(2, log.getXWins(), "X wins should be 2");
        assertEquals(1, log.getOWins(), "O wins should be 1");
        assertEquals(1, log.getTies(),  "Ties should be 1");
    }

    @Test
    void recordTie_incrementsTieCount() {
        GameLog log = new GameLog();

        log.recordTie();
        log.recordTie();

        assertEquals(2, log.getTies(), "Ties should be 2");
    }

    @Test
    void saveToFile_createsGameLogFile() {
        GameLog log = new GameLog();

        log.recordResult('X');
        log.saveToFile();

        File file = new File("game_log.txt");
        assertTrue(file.exists(), "game_log.txt should be created");
    }
}
