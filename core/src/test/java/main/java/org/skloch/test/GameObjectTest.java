package main.java.org.skloch.test;

import main.java.org.skloch.game.GameObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

// unit test

@RunWith(GdxTestRunner.class)
public class GameObjectTest {
    private GameObject gameObject;

    @Before
    public void setUp() throws Exception {
        gameObject = new GameObject(0, 0, 32, 32);
        gameObject.put("testKey", 1);
    }

    @Test
    public void testGet() {
        assertEquals(gameObject.get("testKey"), 1);
    }

    @Test
    public void testContainsKey() {
        assertTrue(gameObject.containsKey("testKey"));
    }

}