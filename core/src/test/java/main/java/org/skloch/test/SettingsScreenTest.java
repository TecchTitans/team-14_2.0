package main.java.org.skloch.test;

import com.badlogic.gdx.Screen;
import main.java.org.skloch.game.HustleGame;
import main.java.org.skloch.game.SettingsScreen;
import main.java.org.skloch.game.SoundManager;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

// integration test

@RunWith(GdxTestRunner.class)
public class SettingsScreenTest {
    private HustleGame game;
    private SettingsScreen settingsScreen;
    private Screen previousScreen;

    @Before
    public void setUp() {
        game = mock(HustleGame.class);
        game.soundManager = new SoundManager();
        game.unitTest = true;
        previousScreen = mock(Screen.class);
        settingsScreen = new SettingsScreen(game, previousScreen);
    }

    @Test
    public void testSetMusicVolume() {
        // Set the music volume in the settings screen
        settingsScreen.setMusicVolume(0.75f);

        // Check if the sound manager volume was updated as well
        assertEquals("volume was updated!", settingsScreen.musicVolume, game.soundManager.getMusicVolume(), 0.001);
    }

    @Test
    public void testSetSfxVolume() {
        // Set the sfx volume in the settings screen
        settingsScreen.setSfxVolume(0.75f);

        // Check if the sound manager volume was updated as well
        assertEquals("volume was updated!", settingsScreen.sfxVolume, game.soundManager.getSfxVolume(), 0.001);
    }
}