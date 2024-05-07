package main.java.org.skloch.game;

public class DailyActivities {
    private boolean eatenBreakfast = false;
    private boolean eatenLunch = false;
    private boolean eatenDinner = false;
    private int timesStudied = 0;
    private int hoursStudied = 0;
    private int timesRecreational = 0;
    private int hoursRecreational = 0;
    private int hoursSlept = 0;


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
}