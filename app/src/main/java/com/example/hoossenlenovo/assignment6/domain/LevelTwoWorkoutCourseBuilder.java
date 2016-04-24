package com.example.hoossenlenovo.assignment6.domain;

/**
 * Created by Toshiba on 2016/04/03.
 */
public class LevelTwoWorkoutCourseBuilder implements WorkoutCourseBuilder {

    private WorkoutCourse workoutCourse;

    public LevelTwoWorkoutCourseBuilder() {
        workoutCourse = new WorkoutCourse();
    }

    @Override
    public void buildGeneralFitness() {
        workoutCourse.setGeneralFitness("General Fitness Advance");
    }

    @Override
    public void buildMuscleGain() {
        workoutCourse.setMuscleGain("Muscle Gain Advance");
    }

    @Override
    public void buildWeightLoss() {
        workoutCourse.setWeightLoss("Weight Loss Advance");
    }

    @Override
    public WorkoutCourse getWorkoutCourse() {
        return workoutCourse;
    }
}

