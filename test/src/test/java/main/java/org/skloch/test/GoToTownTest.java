package main.java.org.skloch.test;

import main.java.org.skloch.game.EventManager;
import main.java.org.skloch.game.GameScreen;
import main.java.org.skloch.game.HustleGame;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertTrue;

// integration test

@RunWith(GdxTestRunner.class)
public class GoToTownTest {
    private EventManager eventManager;
    private HustleGame game;
    private GameScreen gameScreen;

    @Before
    public void setUp() {
        game = new HustleGame(1800, 1000);
        gameScreen = new GameScreen(game, 1, "PlayerName");
        eventManager = new EventManager(gameScreen);
    }

    @Test
    public void testGoToTownEvent() {

        String[] args = {"bus_to_town"};
        eventManager.goToTownEvent(args);

        assertTrue(game.isSwitchToTownMapCalled());
    }
}