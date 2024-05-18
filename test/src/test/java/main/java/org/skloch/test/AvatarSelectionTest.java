package main.java.org.skloch.test;

import main.java.org.skloch.game.AvatarSelection;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

// unit test

public class AvatarSelectionTest {

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