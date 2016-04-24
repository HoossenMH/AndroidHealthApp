package com.example.hoossenlenovo.assignment6.domain;

/**
 * Created by Toshiba on 2016/04/07.
 */
public class OverallFitness extends Exercise
{
    private int runnningKm;
    private int skippingRopeAmount;


    public OverallFitness() {
    }

    public OverallFitness(int runnningKm, int skippingRopeAmount) {
        this.runnningKm = runnningKm;
        this.skippingRopeAmount = skippingRopeAmount;
    }


    public int getRunnningKm() {
        return runnningKm;
    }
    public int getSkippingRopeAmount() {
        return skippingRopeAmount;
    }

    @Override
    public String exerciseDone()
    {
        return "is done";
    }
}
