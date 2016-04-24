package com.example.hoossenlenovo.assignment6.domain;

/**
 * Created by Toshiba on 2016/04/07.
 */
public class Weightloss extends Exercise
{
    private int squatAmount;
    private int pushPressAmount;
    private int runnningKm;


    public Weightloss() {
    }

    public Weightloss(int squatAmount, int pushPressAmount, int runnningKm) {
        this.squatAmount = squatAmount;
        this.pushPressAmount = pushPressAmount;
        this.runnningKm = runnningKm;
    }


    public int getSquatAmount() {
        return squatAmount;
    }

    public int getPushPressAmount() {
        return pushPressAmount;
    }

    public int getRunnningKm() {
        return runnningKm;
    }

    @Override
    public String exerciseDone()
    {
        return "is done";
    }
}
