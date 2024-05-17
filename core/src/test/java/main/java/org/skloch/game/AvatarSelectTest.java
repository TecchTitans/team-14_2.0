package main.java.org.skloch.game;

import main.java.org.skloch.game.DailyActivities;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.ThreadLocalRandom;

import static org.junit.Assert.assertEquals;

public class AvatarSelectTest {

    private AvatarSelection avatarSelection;

    @Before
    public void setUp() {
        avatarSelection = new AvatarSelection();
    }
    @Test
    public void testSelectAvatar1() {
        avatarSelection.selectAvatar(1);
        assertEquals(1, avatarSelection.getSelectedAvatar());
    }

    @Test
    public void testSelectAvatar2() {
        avatarSelection.selectAvatar(2);
        assertEquals(2, avatarSelection.getSelectedAvatar());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSelectionInvalidAvatar() {
        avatarSelection.selectAvatar(6);
    }
}