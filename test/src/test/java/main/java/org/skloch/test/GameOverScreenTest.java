package main.java.org.skloch.test;

import main.java.org.skloch.game.GameScreen;
import main.java.org.skloch.game.HustleGame;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertTrue;

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
        assertTrue(gameScreen.testGameOver);
    }

}