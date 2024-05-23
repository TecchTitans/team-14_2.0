package main.java.org.skloch.test;

import main.java.org.skloch.game.DialogueBox;
import main.java.org.skloch.game.EventManager;
import main.java.org.skloch.game.GameScreen;
import main.java.org.skloch.game.HustleGame;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;
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
        String[] args = {"piazza", "testtopic"};

        when(gameScreen.getSeconds()).thenReturn(8 * 60f);
        when(gameScreen.getEnergy()).thenReturn(0);
        eventManager.piazzaEvent(args);

        verify(gameScreen.dialogueBox).setText("You are too tired to meet your friends right now!");

        when(gameScreen.getSeconds()).thenReturn(7 * 60f);
        when(gameScreen.getEnergy()).thenReturn(40);
        eventManager.piazzaEvent(args);

        verify(gameScreen.dialogueBox).setText("It's too early in the morning to meet your friends, go to bed!");


        when(gameScreen.getSeconds()).thenReturn(8 * 60f);
        when(gameScreen.getEnergy()).thenReturn(40);
        eventManager.piazzaEvent(args);

        verify(gameScreen.dialogueBox).setText("You talked about testtopic for 2 hours!");
    }

    @Test
    public void compSciEventTest() {
        EventManager eventManager = new EventManager(gameScreen);
        String[] args = {"comp_sci", "2"};

        when(gameScreen.getSeconds()).thenReturn(8 * 60f);
        when(gameScreen.getEnergy()).thenReturn(0);
        eventManager.compSciEvent(args);

        verify(gameScreen.dialogueBox).setText("You are too tired to study right now!");


        when(gameScreen.getSeconds()).thenReturn(7 * 60f);
        when(gameScreen.getEnergy()).thenReturn(40);
        eventManager.compSciEvent(args);

        verify(gameScreen.dialogueBox).setText("It's too early in the morning to study, go to bed!");


        when(gameScreen.getSeconds()).thenReturn(8 * 60f);
        when(gameScreen.getEnergy()).thenReturn(40);
        eventManager.compSciEvent(args);

        verify(gameScreen.dialogueBox).setText("You studied for 2 hours!\nYou lost 20 energy");


        when(gameScreen.getSeconds()).thenReturn(8 * 60f);
        when(gameScreen.getEnergy()).thenReturn(10);
        eventManager.compSciEvent(args);

        verify(gameScreen.dialogueBox).setText("You don't have the energy to study for this long!");
    }

    @Test
    public void ronCookeEventTest() {
        EventManager eventManager = new EventManager(gameScreen);
        String[] args = {"rch"};

        when(gameScreen.getSeconds()).thenReturn(8 * 60f);
        when(gameScreen.getEnergy()).thenReturn(0);
        eventManager.ronCookeEvent(args);

        verify(gameScreen.dialogueBox).setText("You are too tired to eat right now!");


        when(gameScreen.getSeconds()).thenReturn(7 * 60f);
        when(gameScreen.getEnergy()).thenReturn(40);
        eventManager.ronCookeEvent(args);

        verify(gameScreen.dialogueBox).setText("It's too early in the morning to eat food, go to bed!");


        when(gameScreen.getSeconds()).thenReturn(8 * 60f);
        when(gameScreen.getEnergy()).thenReturn(40);
        when(gameScreen.getMeal()).thenReturn("breakfast");
        eventManager.ronCookeEvent(args);

        verify(gameScreen.dialogueBox).setText("You took an hour to eat breakfast at the Ron Cooke Hub!\nYou lost 10 energy!");


        when(gameScreen.getSeconds()).thenReturn(8 * 60f);
        when(gameScreen.getEnergy()).thenReturn(40);
        when(gameScreen.getMeal()).thenReturn("lunch");
        eventManager.ronCookeEvent(args);

        verify(gameScreen.dialogueBox).setText("You took an hour to eat lunch at the Ron Cooke Hub!\nYou lost 10 energy!");


        when(gameScreen.getSeconds()).thenReturn(8 * 60f);
        when(gameScreen.getEnergy()).thenReturn(40);
        when(gameScreen.getMeal()).thenReturn("dinner");
        eventManager.ronCookeEvent(args);

        verify(gameScreen.dialogueBox).setText("You took an hour to eat dinner at the Ron Cooke Hub!\nYou lost 10 energy!");
    }

    @Test
    public void pubEventTest() {
        EventManager eventManager = new EventManager(gameScreen);
        String[] args = {"pub", "2"};

        when(gameScreen.getSeconds()).thenReturn(9 * 60f);
        when(gameScreen.getEnergy()).thenReturn(0);
        eventManager.pubEvent(args);

        verify(gameScreen.dialogueBox).setText("You are too tired to have a few cheeky ones!");


        when(gameScreen.getSeconds()).thenReturn(9 * 60f);
        when(gameScreen.getEnergy()).thenReturn(40);
        eventManager.pubEvent(args);

        verify(gameScreen.dialogueBox).setText("You had 4 pints in 2 hours!\nYou lost 20 energy!");


        when(gameScreen.getSeconds()).thenReturn(7 * 60f);
        when(gameScreen.getEnergy()).thenReturn(40);
        eventManager.pubEvent(args);

        verify(gameScreen.dialogueBox).setText("It's too early to get on it, go to bed!");
    }

    @Test
    public void himarkEventTest() {
        EventManager eventManager = new EventManager(gameScreen);
        String[] args = {"himark", "2"};

        when(gameScreen.getSeconds()).thenReturn(9 * 60f);
        when(gameScreen.getEnergy()).thenReturn(0);
        eventManager.himarkEvent(args);

        verify(gameScreen.dialogueBox).setText("You are too tired to go shopping!");


        when(gameScreen.getSeconds()).thenReturn(7 * 60f);
        when(gameScreen.getEnergy()).thenReturn(40);
        eventManager.himarkEvent(args);

        verify(gameScreen.dialogueBox).setText("It's too early to go shopping, go to bed!");


        when(gameScreen.getSeconds()).thenReturn(8 * 60f);
        when(gameScreen.getEnergy()).thenReturn(40);
        eventManager.himarkEvent(args);

        verify(gameScreen.dialogueBox).setText("You stayed in Himark for 2 hours!\nYou lost 20 energy!");
    }

    @Test
    public void treeEventTest() {
        EventManager eventManager = new EventManager(gameScreen);
        eventManager.treeEvent();

        verify(gameScreen.dialogueBox).setText("The tree doesn't say anything back.");
        assertTrue(eventManager.isTreeEventCalled());
    }

    @Test
    public void chestEventTest() {
        EventManager eventManager = new EventManager(gameScreen);
        eventManager.chestEvent();

        verify(gameScreen.dialogueBox).setText("Wow! This chest is full of so many magical items! I wonder how they will help you out on your journey! Boy, this is an awfully long piece of text, I wonder if someone is testing something?\n...\n...\n...\nHow cool!");
    }

    @Test
    public void objectEventTest() {
        EventManager eventManager = new EventManager(gameScreen);
        eventManager.objectEvent("testObject");

        verify(gameScreen.dialogueBox).setText("This is a testObject!");
    }

    @Test
    public void objectInteractionTest() {
        EventManager eventManager = new EventManager(gameScreen);

        when(gameScreen.getMeal()).thenReturn("breakfast");
        String result = eventManager.getObjectInteraction("rch");
        assertEquals("result matches!", result, "Eat breakfast at the Ron Cooke Hub?");

        when(gameScreen.getMeal()).thenReturn("lunch");
        result = eventManager.getObjectInteraction("rch");
        assertEquals("result matches!", result, "Eat lunch at the Ron Cooke Hub?");

        when(gameScreen.getMeal()).thenReturn("dinner");
        result = eventManager.getObjectInteraction("rch");
        assertEquals("result matches!", result, "Eat dinner at the Ron Cooke Hub?");


        when(gameScreen.getMeal()).thenReturn("breakfast");
        result = eventManager.getObjectInteraction("luigis");
        assertEquals("result matches!", result, "Eat breakfast at Luigi's Pizza?");

        when(gameScreen.getMeal()).thenReturn("lunch");
        result = eventManager.getObjectInteraction("luigis");
        assertEquals("result matches!", result, "Eat lunch at Luigi's Pizza?");

        when(gameScreen.getMeal()).thenReturn("dinner");
        result = eventManager.getObjectInteraction("luigis");
        assertEquals("result matches!", result, "Eat dinner at Luigi's Pizza?");


        result = eventManager.getObjectInteraction("chest");
        assertEquals("result matches!", result, "Open the chest?");

        result = eventManager.getObjectInteraction("comp_sci");
        assertEquals("result matches!", result, "Study in the Computer Science building?");

        result = eventManager.getObjectInteraction("piazza");
        assertEquals("result matches!", result, "Meet your friends at the Piazza?");

        result = eventManager.getObjectInteraction("accommodation");
        assertEquals("result matches!", result, "Go to sleep for the night?\nYour alarm is set for 8am.");

        result = eventManager.getObjectInteraction("tree");
        assertEquals("result matches!", result, "Speak to the tree?");

        result = eventManager.getObjectInteraction("bus_to_town");
        assertEquals("result matches!", result, "Take a ride to town?");

        result = eventManager.getObjectInteraction("bus_to_east_campus");
        assertEquals("result matches!", result, "Take a ride to east campus?");

        result = eventManager.getObjectInteraction("pub");
        assertEquals("result matches!", result, "Have a few pints and good chit-chat?");

        result = eventManager.getObjectInteraction("himark");
        assertEquals("result matches!", result, "Go shopping in Himark?");

        result = eventManager.getObjectInteraction("library");
        assertEquals("result matches!", result, "Study in the Library?");

        result = eventManager.getObjectInteraction("kosta");
        assertEquals("result matches!", result, "Meet your friends at Kosta Koffee?");

    }

    @Test
    public void randomTopicsTest() {
        EventManager eventManager = new EventManager(gameScreen);

        String[] result = eventManager.randomTopics(4);

        assertEquals("correct number of topics returned!", result.length, 4);
    }

    @Test
    public void libraryEventTest() {
        EventManager eventManager = new EventManager(gameScreen);
        String[] args = {"library", "2"};

        when(gameScreen.getSeconds()).thenReturn(9 * 60f);
        when(gameScreen.getEnergy()).thenReturn(0);
        eventManager.libraryEvent(args);

        verify(gameScreen.dialogueBox).setText("You are too tired to study right now!");


        when(gameScreen.getSeconds()).thenReturn(9 * 60f);
        when(gameScreen.getEnergy()).thenReturn(40);
        eventManager.libraryEvent(args);

        verify(gameScreen.dialogueBox).setText("You studied for 2 hours!\nYou lost 20 energy");


        when(gameScreen.getSeconds()).thenReturn(7 * 60f);
        when(gameScreen.getEnergy()).thenReturn(40);
        eventManager.libraryEvent(args);

        verify(gameScreen.dialogueBox).setText("It's too early in the morning to study, go to bed!");
    }

    @Test
    public void kostaEventTest() {
        EventManager eventManager = new EventManager(gameScreen);
        String[] args = {"kosta", "testtopic"};

        when(gameScreen.getSeconds()).thenReturn(9 * 60f);
        when(gameScreen.getEnergy()).thenReturn(0);
        eventManager.kostaEvent(args);

        verify(gameScreen.dialogueBox).setText("You are too tired to meet your friends right now!");


        when(gameScreen.getSeconds()).thenReturn(9 * 60f);
        when(gameScreen.getEnergy()).thenReturn(40);
        eventManager.kostaEvent(args);

        verify(gameScreen.dialogueBox).setText("You talked about testtopic for 2 hours!");


        when(gameScreen.getSeconds()).thenReturn(7 * 60f);
        when(gameScreen.getEnergy()).thenReturn(40);
        eventManager.kostaEvent(args);

        verify(gameScreen.dialogueBox).setText("It's too early in the morning to meet your friends, go to bed!");
    }

    @Test
    public void luigisEventTest() {
        EventManager eventManager = new EventManager(gameScreen);
        String[] args = {"luigis"};

        when(gameScreen.getSeconds()).thenReturn(9 * 60f);
        when(gameScreen.getEnergy()).thenReturn(0);
        eventManager.luigisEvent(args);

        verify(gameScreen.dialogueBox).setText("You are too tired to eat right now!");


        when(gameScreen.getMeal()).thenReturn("breakfast");
        when(gameScreen.getSeconds()).thenReturn(9 * 60f);
        when(gameScreen.getEnergy()).thenReturn(40);
        eventManager.luigisEvent(args);

        verify(gameScreen.dialogueBox).setText("You took an hour to eat breakfast at Luigi's Pizza!\nYou lost 10 energy!");

        when(gameScreen.getMeal()).thenReturn("lunch");
        when(gameScreen.getSeconds()).thenReturn(9 * 60f);
        when(gameScreen.getEnergy()).thenReturn(40);
        eventManager.luigisEvent(args);

        verify(gameScreen.dialogueBox).setText("You took an hour to eat lunch at Luigi's Pizza!\nYou lost 10 energy!");

        when(gameScreen.getMeal()).thenReturn("dinner");
        when(gameScreen.getSeconds()).thenReturn(9 * 60f);
        when(gameScreen.getEnergy()).thenReturn(40);
        eventManager.luigisEvent(args);

        verify(gameScreen.dialogueBox).setText("You took an hour to eat dinner at Luigi's Pizza!\nYou lost 10 energy!");


        when(gameScreen.getSeconds()).thenReturn(7 * 60f);
        when(gameScreen.getEnergy()).thenReturn(40);
        eventManager.luigisEvent(args);

        verify(gameScreen.dialogueBox).setText("It's too early in the morning to eat food, go to bed!");
    }


}