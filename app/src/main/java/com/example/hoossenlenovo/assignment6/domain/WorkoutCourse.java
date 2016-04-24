package com.example.hoossenlenovo.assignment6.domain;

/**
 * Created by Toshiba on 2016/04/03.
 */
public class WorkoutCourse
{

    private String generalFitness;
    private String muscleGain;
    private String weightLoss;

    public String getGeneralFitness() {
        return generalFitness;
    }
    public void setGeneralFitness(String generalFitness) {
        this.generalFitness = generalFitness;
    }
    public String getMuscleGain() {
        return muscleGain;
    }
    public void setMuscleGain(String muscleGain) {
        this.muscleGain = muscleGain;
    }
    public String getWeightLoss() {
        return weightLoss;
    }
    public void setWeightLoss(String weightLoss) {
        this.weightLoss = weightLoss;
    }


    @Override
    public String toString()
    {
        return "WorkoutCourse{" +
                "buildGeneralFitness='" + generalFitness + '\'' +
                ", buildMuscleGain='" + muscleGain + '\'' +
                ", buildWeightLoss='" + weightLoss + '\'' +
                '}';
    }
}
