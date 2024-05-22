import com.badlogic.gdx.Game;
import main.java.org.skloch.game.GameOverScreen;
import main.java.org.skloch.game.GameScreen;
import main.java.org.skloch.game.HustleGame;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.HashSet;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

// integration test

@RunWith(GdxTestRunner.class)
public class GameOverScreenTest {
    private GameScreen gameScreen;
    private GameOverScreen gameOverScreen;
    private HustleGame game;

    @Before
    public void setUp(){
        //game = new HustleGame(1280, 720);
        //game.unitTest = true;
        gameScreen = mock(GameScreen.class);
    }

    @Test
    public void gameOverScreenAfterSevenDays() {
        gameScreen.passTime(24 * 60 * 8);
        assertTrue(gameScreen.testGameOver);
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