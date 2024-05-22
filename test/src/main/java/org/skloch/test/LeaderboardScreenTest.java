package main.java.org.skloch.test;

import com.badlogic.gdx.Screen;
import main.java.org.skloch.game.HustleGame;
import main.java.org.skloch.game.LeaderboardScreen;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

// integration test

@RunWith(GdxTestRunner.class)

public class LeaderboardScreenTest {
    private HustleGame game;
    private LeaderboardScreen leaderboardScreen;
    private Screen previousScreen;

    @Before
    public void setUp() {
        game = mock(HustleGame.class);
        game.unitTest = true;
        previousScreen = mock(Screen.class);
        leaderboardScreen = new LeaderboardScreen(game, previousScreen);
    }

    @Test
    public void testLeaderboardScreenInitialization() {
        assertEquals(LeaderboardScreen.class, leaderboardScreen.getClass());
    }

    @Test
    public void testRender() {
        leaderboardScreen.render(1.0f);
    }

}