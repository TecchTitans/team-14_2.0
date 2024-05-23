package main.java.org.skloch.test;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import main.java.org.skloch.game.GameObject;
import main.java.org.skloch.game.Player;
import main.java.org.skloch.test.GdxTestRunner;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(GdxTestRunner.class)
public class PlayerTest {

    @Test
    public void getPosAsVectorTest() {
        Player player = new Player("avatar1", "testName", true);

        Vector3 pos = player.getPosAsVec3();

        assertEquals(new Vector3(0, 0, 0), pos);
    }

    @Test
    public void setXTest() {
        Player player = new Player("avatar1", "testName", true);

        player.setX(20);

        assertEquals(player.getX(), 20, 0.001);
    }

    @Test
    public void setYTest() {
        Player player = new Player("avatar1", "testName", true);

        player.setY(20);

        assertEquals(player.getY(), 20, 0.001);
    }

    @Test
    public void setPosTest() {
        Player player = new Player("avatar1", "testName", true);

        player.setPos(30, 40);

        assertEquals(player.getX(), 30, 0.001);
        assertEquals(player.getY(), 40, 0.001);
        assertEquals(player.getPosAsVec3(), new Vector3(30, 40, 0));
    }

    @Test
    public void setBoundsTest() {
        Rectangle bounds = new Rectangle(20, 20, 40, 40);
        Player player = new Player("avatar1", "testName", true);

        player.setBounds(bounds);

        assertEquals(player.bounds, bounds);
    }

    @Test
    public void distanceFromTest() {
        Player player = new Player("avatar1", "testName", true);
        player.setPos(0, 0);

        GameObject testObject = new GameObject(30, 53, 0, 0);

        assertEquals(player.distanceFrom(testObject), 5, 0.001);
    }
}