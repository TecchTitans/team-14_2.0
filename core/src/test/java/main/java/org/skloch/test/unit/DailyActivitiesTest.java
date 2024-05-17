package main.java.org.skloch.test.unit;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.concurrent.ThreadLocalRandom;

public class DailyActivitiesTest {
    private final DailyActivities dailyActivities = new DailyActivities();

    @Test
    public void testAddHoursRecreation() {
        int random_hours = ThreadLocalRandom.current().nextInt(1, 100);
        assertEquals(dailyActivities.getHoursRecreation(), 0);
        dailyActivities.addHoursRecreation(random_hours);
        assertEquals(dailyActivities.getHoursRecreation(), random_hours);
    }
}