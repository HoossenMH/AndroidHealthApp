package com.example.hoossenlenovo.assignment6.domain;

/**
 * Created by Toshiba on 2016/04/03.
 */
public interface WorkoutCourseBuilder {

    public void buildGeneralFitness();
    public void buildMuscleGain();
    public void buildWeightLoss();

    public WorkoutCourse getWorkoutCourse();
}
