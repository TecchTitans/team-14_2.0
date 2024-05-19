package main.java.org.skloch.game;

import java.util.HashMap;

public class DailyActivities {
    private boolean eatenBreakfast = false;
    private boolean eatenLunch = false;
    private boolean eatenDinner = false;
    private int timesStudied = 0;
    private int hoursStudied = 0;
    private int timesRecreational = 0;
    private int hoursRecreational = 0;
    private int hoursSlept = 0;

    //private ArrayList<String> activitiesDone = new ArrayList<String>();
    private HashMap<String, Integer> activitiesDone = new HashMap<>();


    // getters
    public boolean isEatenBreakfast() {
        return eatenBreakfast;
    }

    public boolean isEatenLunch() {
        return eatenLunch;
    }

    public boolean isEatenDinner() {
        return eatenDinner;
    }

    public int getHoursRecreation() {
        return hoursRecreational;
    }

    public int getHoursSlept() {
        return hoursSlept;
    }

    public int getHoursStudied() {
        return hoursStudied;
    }

    public int getTimesRecreation() {
        return timesRecreational;
    }

    public int getTimesStudied() {
        return timesStudied;
    }

    //public ArrayList<String> getActivitiesDone() { return activitiesDone; }
    //public HashMap<String, Integer> getActivitiesDone() { return activitiesDone; }

    public int getActivityDone(String activity) {
        return activitiesDone.getOrDefault(activity, 0);
    }


    // setters
    public void setEatenBreakfast(boolean eatenBreakfast) {
        this.eatenBreakfast = eatenBreakfast;
    }

    public void setEatenDinner(boolean eatenDinner) {
        this.eatenDinner = eatenDinner;
    }

    public void setEatenLunch(boolean eatenLunch) {
        this.eatenLunch = eatenLunch;
    }


    //other mutators
    public void addHoursRecreation(int hoursRecreation) {
        this.hoursRecreational += hoursRecreation;
        addTimesRecreation(1);
    }

    public void addHoursSlept(int hoursSlept) {
        this.hoursSlept += hoursSlept;
    }

    public void addHoursStudied(int hoursStudied) {
        this.hoursStudied += hoursStudied;
        addTimesStudied(1);
    }

    //could just do these whenever add hours is called.
    public void addTimesRecreation(int timesRecreation) {
        this.timesRecreational += timesRecreation;
    }

    public void addTimesStudied(int timesStudied) {
        this.timesStudied += timesStudied;
    }

    //public void addActivityDone(String activity) { this.activitiesDone.add(activity); }
    public void addActivityDone(String activity) {
        if(activitiesDone.containsKey(activity)) {
            activitiesDone.put(activity, activitiesDone.get(activity) + 1);
        } else {
          activitiesDone.put(activity, 1);
        }
    }

}