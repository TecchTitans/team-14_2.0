package com.skloch.game;

public class DailyActivities {
    boolean eatenBreakfast = false;
    boolean eatenLunch = false;
    boolean eatenDinner = false;
    int timesStudied = 0;
    int hoursStudied = 0;
    int timesRecreational = 0;
    int hoursRecreational = 0;
    int hoursSlept = 0;


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

    public void addHoursRecreation(int hoursRecreation) {
        this.hoursRecreational += hoursRecreation;
    }

    public void addHoursSlept(int hoursSlept) {
        this.hoursSlept += hoursSlept;
    }

    public void addHoursStudied(int hoursStudied) {
        this.hoursStudied += hoursStudied;
    }

    //could just do these whenevr add hours is called.
    public void addTimesRecreation(int timesRecreation) {
        this.timesRecreational += timesRecreation;
    }

    public void addTimesStudied(int timesStudied) {
        this.timesStudied += timesStudied;
    }
}