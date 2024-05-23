package main.java.org.skloch.game;

import java.util.HashMap;

/**
 * A class that tracks the players activities throughout the day.
 *
 * Tracks the following:
 * - If player has eaten breakfast
 * - If players has eaten lunch
 * - If player has eaten dinner
 * - How many times player has studied
 * - How many hours the player has studied for
 * - How many times a player has done recreational activities
 * - How many hours the player has done recreational activities
 * - How many hours the player has slept
 * - How many times a player has visited a specific activity
 */
public class DailyActivities {
    private boolean eatenBreakfast = false;
    private boolean eatenLunch = false;
    private boolean eatenDinner = false;
    private int timesStudied = 0;
    private int hoursStudied = 0;
    private int timesRecreational = 0;
    private int hoursRecreational = 0;
    private int hoursSlept = 0;

    private HashMap<String, Integer> activitiesDone = new HashMap<>();


    // getters

    /**
     * Gets a boolean indicating whether the player has eaten breakfast or not
     *
     * @return a boolean true if player has eaten breakfast, false otherwise.
     */
    public boolean isEatenBreakfast() {
        return eatenBreakfast;
    }

    /**
     * Gets a boolean indicating whether the player has eaten lunch or not
     *
     * @return a boolean true if player has eaten lunch, false otherwise.
     */
    public boolean isEatenLunch() {
        return eatenLunch;
    }

    /**
     * Gets a boolean indicating whether the player has eaten dinner or not
     *
     * @return a boolean true if player has eaten dinner, false otherwise.
     */
    public boolean isEatenDinner() {
        return eatenDinner;
    }

    /**
     * Gets the number of hours the player has done recreational activities
     *
     * @return an integer showing the number of hours the player has done recreational activities
     */
    public int getHoursRecreation() {
        return hoursRecreational;
    }

    /**
     * Gets the number of hours the player has slept
     *
     * @return an integer showing the number of hours the player has slept
     */
    public int getHoursSlept() {
        return hoursSlept;
    }

    /**
     * Gets the number of hours the player has studied
     *
     * @return an integer showing the number of hours the player has slept
     */
    public int getHoursStudied() {
        return hoursStudied;
    }

    /**
     * Gets the number of times the player has done recreational activities
     *
     * @return an integer showing the number of times the player has done recreational activities
     */
    public int getTimesRecreation() {
        return timesRecreational;
    }

    /**
     * Gets the number of times the player has studied
     *
     * @return an integer showing the number of times the player has studied
     */
    public int getTimesStudied() {
        return timesStudied;
    }

    /**
     * Gets the number of times the player has visited a specific activity
     *
     * @param activity - A string representing the activity
     * @return an integer showing the number of times the player has done that activity
     */
    public int getActivityDone(String activity) {
        return activitiesDone.getOrDefault(activity, 0);
    }


    // setters

    /**
     * sets the eatenBreakfast field
     *
     * @param eatenBreakfast - boolean to set the value to
     */
    public void setEatenBreakfast(boolean eatenBreakfast) {
        this.eatenBreakfast = eatenBreakfast;
    }

    /**
     * sets the eatenDinner field
     *
     * @param eatenDinner - boolean to set the value to
     */
    public void setEatenDinner(boolean eatenDinner) {
        this.eatenDinner = eatenDinner;
    }

    /**
     * sets the eatenLunch field
     *
     * @param eatenLunch - boolean to set the value to
     */
    public void setEatenLunch(boolean eatenLunch) {
        this.eatenLunch = eatenLunch;
    }


    //other mutators

    /**
     * Adds a number of hours to the hoursRecreational field
     *
     * @param hoursRecreation - number of hours to add
     */
    public void addHoursRecreation(int hoursRecreation) {
        this.hoursRecreational += hoursRecreation;
        addTimesRecreation(1);
    }

    /**
     * Adds a number of hours to the hoursSlept field
     *
     * @param hoursSlept - number of hours to add
     */
    public void addHoursSlept(int hoursSlept) {
        this.hoursSlept += hoursSlept;
    }

    /**
     * Adds a number of hours to the hoursStudies field
     *
     * @param hoursStudied - number of hours to add
     */
    public void addHoursStudied(int hoursStudied) {
        this.hoursStudied += hoursStudied;
        addTimesStudied(1);
    }

    //could just do these whenever add hours is called.
    /**
     * Adds a given number to the timesRecreational field
     *
     * @param timesRecreation - the number to add
     */
    public void addTimesRecreation(int timesRecreation) {
        this.timesRecreational += timesRecreation;
    }

    /**
     * Adds a given number to the timesStudies field
     *
     * @param timesStudied - the number to add
     */
    public void addTimesStudied(int timesStudied) {
        this.timesStudied += timesStudied;
    }

    /**
     * increments the number of times a player has done a specific activity
     *
     * @param activity - the activity to increment
     */
    public void addActivityDone(String activity) {
        if(activitiesDone.containsKey(activity)) {
            activitiesDone.put(activity, activitiesDone.get(activity) + 1);
        } else {
          activitiesDone.put(activity, 1);
        }
    }

}