package com.example.hoossenlenovo.assignment6.domain;

/**
 * Created by Toshiba on 2016/04/07.
 */
public class MuscleGain extends Exercise {

    private int chestsAmount;
    private int benchPressAmount;
    private int inclineBenchPressAmount;

    public MuscleGain() {
    }

    public MuscleGain(int chestsAmount, int benchPressAmount, int inclineBenchPressAmount) {
        this.chestsAmount = chestsAmount;
        this.benchPressAmount = benchPressAmount;
        this.inclineBenchPressAmount = inclineBenchPressAmount;
    }



    public int getBenchPressAmount() {
        return benchPressAmount;
    }

    public int getChestsAmount() {
        return chestsAmount;
    }

    public int getInclineBenchPressAmount() {
        return inclineBenchPressAmount;
    }

    @Override
    public String exerciseDone()
    {
        return "is done";
    }
}
