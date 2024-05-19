package main.java.org.skloch.test;

import main.java.org.skloch.game.CreditScreen;
import main.java.org.skloch.game.HustleGame;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.badlogic.gdx.Screen;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

// unit test

@RunWith(GdxTestRunner.class)

public class CreditScreenTest {
    private HustleGame game;
    private CreditScreen creditScreen;
    private Screen previousScreen;

    @Before
    public void setUp() {
        game = mock(HustleGame.class);
        game.unitTest = true;
        previousScreen = mock(Screen.class);
        creditScreen = new CreditScreen(game, previousScreen);
    }

    @Test
    public void testCreditScreenInitialization() {
        assertEquals(CreditScreen.class, creditScreen.getClass());
    }

    @Test
    public void testRender() {
        creditScreen.render(1.0f);
    }

}