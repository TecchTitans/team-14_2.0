package main.java.org.skloch.test;

import com.badlogic.gdx.Screen;
import main.java.org.skloch.game.CreditScreen;
import main.java.org.skloch.game.GameScreen;
import main.java.org.skloch.game.HustleGame;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

@RunWith(GdxTestRunner.class)

public class GameOverScreenTest {
    GameScreen gameScreen;
    HustleGame game;
    @Before
    public void setUp(){
        game = new HustleGame(1280, 720);
        game.unitTest = true;
        gameScreen = new GameScreen(game, 1, "name");
    }

    @Test
    public void gameOverScreenAfterSevenDays(){
        gameScreen.setDay(8);
        gameScreen.passTime(1);
        Assert.assertTrue(gameScreen.testGameOver);
    }

}