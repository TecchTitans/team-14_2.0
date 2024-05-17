package main.java.org.skloch.game;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class GoToTownTest {
    private EventManager eventManager;
    private HustleGame game;

    @Before
    public void setUp() {
        game = new HustleGame(1800, 1000);
        GameScreen gameScreen = new GameScreen(game, 1, "PlayerName");
        eventManager = new EventManager(gameScreen);
    }

    @Test
    public void testGoToTownEvent() {

        String[] args = {"bus_to_town"};
        eventManager.goToTownEvent(args);

        assertTrue(game.isSwitchToTownMapCalled());
    }
}