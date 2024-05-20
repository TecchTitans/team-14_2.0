package main.java.org.skloch.test;

import main.java.org.skloch.game.DailyActivities;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.ThreadLocalRandom;
import static org.junit.Assert.*;

// unit test

public class DailyActivitiesTest {
    private DailyActivities dailyActivities;

    @Before
    public void setUp() { dailyActivities = new DailyActivities(); }


    @Test
    public void testAddHoursRecreation() {
        int random_hours = ThreadLocalRandom.current().nextInt(1, 100);
        assertEquals(dailyActivities.getHoursRecreation(), 0);
        dailyActivities.addHoursRecreation(random_hours);
        assertEquals(dailyActivities.getHoursRecreation(), random_hours);
    }

    @Test
    public void testAddHoursSlept() {
        int random_hours = ThreadLocalRandom.current().nextInt(1, 100);
        assertEquals(dailyActivities.getHoursSlept(), 0);
        dailyActivities.addHoursSlept(random_hours);
        assertEquals(dailyActivities.getHoursSlept(), random_hours);
    }

    @Test
    public void testAddHoursStudied() {
        int random_hours = ThreadLocalRandom.current().nextInt(1, 100);
        assertEquals(dailyActivities.getHoursStudied(), 0);
        dailyActivities.addHoursStudied(random_hours);
        assertEquals(dailyActivities.getHoursStudied(), random_hours);
    }

    @Test
    public void testAddTimesRecreation() {
        int random_hours = ThreadLocalRandom.current().nextInt(1, 100);
        assertEquals(dailyActivities.getTimesRecreation(), 0);
        dailyActivities.addTimesRecreation(random_hours);
        assertEquals(dailyActivities.getTimesRecreation(), random_hours);
    }

    @Test
    public void testAddTimesStudied() {
        int random_hours = ThreadLocalRandom.current().nextInt(1, 100);
        assertEquals(dailyActivities.getTimesStudied(), 0);
        dailyActivities.addTimesStudied(random_hours);
        assertEquals(dailyActivities.getTimesStudied(), random_hours);
    }

    @Test
    public void testAddActivityDone() {

        assertEquals(dailyActivities.getActivityDone("piazza"), 0);
        dailyActivities.addActivityDone("piazza");
        assertEquals(dailyActivities.getActivityDone("piazza"), 1);
        dailyActivities.addActivityDone("piazza");
        assertEquals(dailyActivities.getActivityDone("piazza"), 2);
    }

    @Test
    public void testSetEatenBreakfast() {
        assertFalse(dailyActivities.isEatenBreakfast());
        dailyActivities.setEatenBreakfast(true);
        assertTrue(dailyActivities.isEatenBreakfast());
    }

    @Test
    public void testSetEatenDinner() {
        assertFalse(dailyActivities.isEatenDinner());
        dailyActivities.setEatenDinner(true);
        assertTrue(dailyActivities.isEatenDinner());
    }

    @Test
    public void testSetEatenLunch() {
        assertFalse(dailyActivities.isEatenLunch());
        dailyActivities.setEatenLunch(true);
        assertTrue(dailyActivities.isEatenLunch());
    }

}