package test.java.main.java.org.skloch.test;

import main.java.org.skloch.game.DialogueBox;
import main.java.org.skloch.game.EventManager;
import main.java.org.skloch.game.GameScreen;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

// integration test

@RunWith(GdxTestRunner.class)
public class EventManagerTest {
    private GameScreen gameScreen;

    @Before
    public void setUp(){
        gameScreen = mock(GameScreen.class);
        gameScreen.dialogueBox = mock(DialogueBox.class);
        // Time will be too early
    }
    @Test
    public void piazzaEventTest() {
        EventManager eventManager = new EventManager(gameScreen);
        String[] args = {"piazza", "topic"};

        when(gameScreen.getSeconds()).thenReturn(8 * 60f);
        eventManager.piazzaEvent(args);

        verify(gameScreen.dialogueBox).setText("You are too tired to meet your friends right now!");
    }

    @Test
    public void compSciEventTest() {
        EventManager eventManager = new EventManager(gameScreen);
        String[] args = {"comp_sci"};

        when(gameScreen.getSeconds()).thenReturn(8 * 60f);
        when(gameScreen.getEnergy()).thenReturn(0);
        eventManager.compSciEvent(args);

        verify(gameScreen.dialogueBox).setText("You are too tired to study right now!");
    }

    @Test
    public void ronCookeEventTest() {
        EventManager eventManager = new EventManager(gameScreen);
        String[] args = {"rch"};

        when(gameScreen.getSeconds()).thenReturn(8 * 60f);
        when(gameScreen.getEnergy()).thenReturn(0);
        eventManager.ronCookeEvent(args);

        verify(gameScreen.dialogueBox).setText("You are too tired to eat right now!");
    }

    @Test
    public void pubEventTest() {
        EventManager eventManager = new EventManager(gameScreen);
        String[] args = {"pub"};

        when(gameScreen.getSeconds()).thenReturn(9 * 60f);
        when(gameScreen.getEnergy()).thenReturn(0);
        eventManager.pubEvent(args);

        verify(gameScreen.dialogueBox).setText("You are too tired to have a few cheeky ones!");
    }

    @Test
    public void himarkEventTest() {
        EventManager eventManager = new EventManager(gameScreen);
        String[] args = {"himark"};

        when(gameScreen.getSeconds()).thenReturn(9 * 60f);
        when(gameScreen.getEnergy()).thenReturn(0);
        eventManager.himarkEvent(args);

        verify(gameScreen.dialogueBox).setText("You are too tired to go shopping!");
    }

    @Test
    public void treeEventTest() {
        EventManager eventManager = new EventManager(gameScreen);
        eventManager.treeEvent();

        verify(gameScreen.dialogueBox).setText("The tree doesn't say anything back.");
        assertTrue(eventManager.isTreeEventCalled());
    }

}