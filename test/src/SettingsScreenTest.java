import com.badlogic.gdx.Screen;
import main.java.org.skloch.game.HustleGame;
import main.java.org.skloch.game.SettingsScreen;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

// integration test

@RunWith(GdxTestRunner.class)

public class SettingsScreenTest {
    private HustleGame game;
    private SettingsScreen settingsScreen;
    private Screen previousScreen;

    @Before
    public void setUp() {
        game = mock(HustleGame.class);
        game.unitTest = true;
        previousScreen = mock(Screen.class);
        settingsScreen = new SettingsScreen(game, previousScreen);
    }

    @Test
    public void testSettingsScreenInitialization() {
        assertEquals(SettingsScreen.class, settingsScreen.getClass());
    }

    @Test
    public void testRender() {
        settingsScreen.render(1.0f);
    }

}