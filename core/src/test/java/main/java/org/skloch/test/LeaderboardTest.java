package main.java.org.skloch.test;

import main.java.org.skloch.game.HustleGame;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Random;

import static org.junit.Assert.assertTrue;

// unit test

@RunWith(GdxTestRunner.class)
public class LeaderboardTest {
    private HustleGame game;

    @Before
    public void setUp() {
        game = new HustleGame(1000, 1000);
    }

    @Test
    public void testAddPlayer() {
        String name = "testName";
        int score = 1000;

        game.leaderboard = new String[0][];

        game.addPlayerToLeaderboard(name, score, false);

        // Check length
        assertTrue("One player has been added!", game.leaderboard.length == 1);

        // Check if name matches
        assertTrue("Name is correct!", game.leaderboard[0][0].equals(name));

        // Check if score matches
        assertTrue("Score is correct!", game.leaderboard[0][1].equals(String.valueOf(score)));

    }

    @Test
    public void testAddPlayerToFullLeaderboard() {
        game.leaderboard = new String[0][];

        for (int i = 0; i < 10; i++) {
            String name = "testName";
            int score = 100;

            game.addPlayerToLeaderboard(name, score, false);

            // Check if name matches
            assertTrue("Name is correct!", game.leaderboard[i][0].equals(name));

            // Check if score matches
            assertTrue("Score is correct!", game.leaderboard[i][1].equals(String.valueOf(score)));
        }

        // Check leaderboard is full
        assertTrue("Leaderboard is full!", game.leaderboard.length == 10);

        // Attempt to add new player
        game.addPlayerToLeaderboard("testName", 1000, false);

        // Check length unchanged
        assertTrue("Leaderboard length unchanged!", game.leaderboard.length == 10);
    }

    @Test
    public void testScoresInOrder() {
        game.leaderboard = new String[0][];

        for (int i = 0; i < 10; i++) {
            String name = "testName";
            int score = (new Random()).nextInt(2000);

            game.addPlayerToLeaderboard(name, score, false);
        }

        for (int i = 1; i < 10; i++) {
            int currentScore = Integer.parseInt(game.leaderboard[i][1]);
            int prevScore = Integer.parseInt(game.leaderboard[i-1][1]);

            assertTrue("Scores are in order", currentScore <= prevScore);
        }
    }
}
