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
        game = new HustleGame(1280, 720);
        game.unitTest = true;
        gameScreen = mock(GameScreen.class);
    }

    @Test
    public void gameOverScreenAfterSevenDays() {
        gameScreen.passTime(24 * 60 * 8);
        assertTrue(gameScreen.testGameOver);
    }

    @Test
    public void
}