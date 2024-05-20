package main.java.org.skloch.test;

import com.badlogic.gdx.maps.MapProperties;
import com.badlogic.gdx.maps.tiled.TiledMap;
import main.java.org.skloch.game.HustleGame;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

// unit test

public class HustleGameTest {
    private HustleGame hustleGame;

//    private TiledMap map;
    private TiledMap eastMap;
    private TiledMap townMap;
//    private MapProperties mapProperties;
    private MapProperties eastMapProperties;
    private MapProperties townMapProperties;

    @Before
    public void setUp() throws Exception {
        hustleGame = new HustleGame(1280, 720);
    }

    @Test
    public void testSwitchToTownMap() {
        hustleGame.switchToTownMap();
        assertEquals(hustleGame.getMap(), townMap);
        assertEquals(hustleGame.getMapProperties(), townMapProperties);
    }

    @Test
    public void testSwitchToEastMap() {
        hustleGame.switchToEastMap();
        assertEquals(hustleGame.getMap(), eastMap);
        assertEquals(hustleGame.getMapProperties(), eastMapProperties);
    }

}