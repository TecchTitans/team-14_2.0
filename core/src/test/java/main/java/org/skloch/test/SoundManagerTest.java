package main.java.org.skloch.test;

import main.java.org.skloch.game.SoundManager;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

// unit test

@RunWith(GdxTestRunner.class)
public class SoundManagerTest {
    private SoundManager soundManager;

    @Before
    public void setUp() {
        soundManager = new SoundManager();
    }

    @Test
    public void testSetMusicVolume() {
        float volume = 0.5f;
        soundManager.setMusicVolume((volume));
        assertEquals(volume, soundManager.getMusicVolume(), 0.001);
    }

    @Test
    public void testSetSfxVolume() {
        float volume = 0.5f;
        soundManager.setSfxVolume(volume);
        assertEquals(volume, soundManager.getSfxVolume(), 0.001);
    }

}