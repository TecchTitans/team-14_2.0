import main.java.org.skloch.game.GameOverScreen;
import main.java.org.skloch.game.GameScreen;
import main.java.org.skloch.game.HustleGame;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

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
        gameScreen = new GameScreen(game, 1, "name");
        gameOverScreen = mock(GameOverScreen.class);
    }

    @Test
    public void gameOverScreenAfterSevenDays() {
        gameScreen.setDay(8);
        gameScreen.passTime(1);
        assertTrue(gameScreen.testGameOver);
    }

    @Test
    public void testRender() { gameOverScreen.render(1.0f);
    }
}