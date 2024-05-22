package test.java.main.java.org.skloch.test;

import main.java.org.skloch.game.GameScreen;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.HashSet;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

// integration test

@RunWith(GdxTestRunner.class)
public class GameOverScreenTest {
    @Before
    public void setUp(){

    }

    @Test
    public void testPlayerPassExams() {
        int daysStudied = 7;
        int totalTimesStudied = 7;
        int totalHoursStudied = 14;
        int totalHoursRecreation = 8;
        int daysEatenBreakfast = 7;
        int daysEatenLunch = 7;
        int daysEatenDinner = 7;

        HashSet<String> streaks = new HashSet<>();
        streaks.add("Social Butterfly");
        streaks.add("Explorer");

        int score = GameScreen.calculateScore(  daysStudied,
                                    totalTimesStudied,
                                    totalHoursStudied,
                                    totalHoursRecreation,
                                    daysEatenBreakfast,
                                    daysEatenLunch,
                                    daysEatenDinner,
                                    streaks);

        assertTrue("Player passed exams!", score > 0);
    }

    @Test
    public void testPlayerFailExams() {
        int daysStudied = 5;
        int totalTimesStudied = 5;
        int totalHoursStudied = 10;
        int totalHoursRecreation = 8;
        int daysEatenBreakfast = 7;
        int daysEatenLunch = 7;
        int daysEatenDinner = 7;

        HashSet<String> streaks = new HashSet<>();
        streaks.add("Social Butterfly");
        streaks.add("Explorer");

        int score = GameScreen.calculateScore(  daysStudied,
                totalTimesStudied,
                totalHoursStudied,
                totalHoursRecreation,
                daysEatenBreakfast,
                daysEatenLunch,
                daysEatenDinner,
                streaks);

        assertTrue("Player passed exams!", score == 0);
    }
}