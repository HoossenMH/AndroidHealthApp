package com.example.hoossenlenovo.assignment6.domain;

/**
 * Created by Toshiba on 2016/04/03.
 */
public class LevelOneWorkoutCourseBuilder implements WorkoutCourseBuilder {

    private WorkoutCourse workoutCourse;

    public LevelOneWorkoutCourseBuilder() {
        workoutCourse = new WorkoutCourse();
    }

    @Override
    public void buildGeneralFitness() {
        workoutCourse.setGeneralFitness("General Fitness Beginner");
    }

    @Override
    public void buildMuscleGain() {
        workoutCourse.setMuscleGain("Muscle Gain Beginner");
    }

    @Override
    public void buildWeightLoss() {
        workoutCourse.setWeightLoss("Weight Loss Beginner");
    }

    @Override
    public WorkoutCourse getWorkoutCourse() {
        return workoutCourse;
    }
}
