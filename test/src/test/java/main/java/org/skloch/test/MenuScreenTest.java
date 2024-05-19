package main.java.org.skloch.test;

import main.java.org.skloch.game.HustleGame;
import main.java.org.skloch.game.MenuScreen;
import org.junit.Before;
import org.junit.Test;

import com.badlogic.gdx.Screen;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

// unit test

//public class MenuScreenTest {
//    private HustleGame game;
//    private MenuScreen menuScreen;
//    private Screen previousScreen;
//
//    @Before
//    public void setUp() {
//        game = mock(HustleGame.class);
//        game.unitTest = true;
//        previousScreen = mock(Screen.class);
//        menuScreen = new MenuScreen(game, previousScreen);
//    }
//
//    @Test
//    public void testCreditScreenInitialization() {
//        assertEquals(MenuScreen.class, menuScreen.getClass());
//    }
//
//    @Test
//    public void testRender() {
//        menuScreen.render(1.0f);
//    }
//
//}