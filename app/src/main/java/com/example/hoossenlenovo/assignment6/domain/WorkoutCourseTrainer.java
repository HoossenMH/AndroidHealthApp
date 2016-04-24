package com.example.hoossenlenovo.assignment6.domain;

/**
 * Created by Toshiba on 2016/04/03.
 */
public class WorkoutCourseTrainer {

    private WorkoutCourseBuilder workoutCourseBuilder = null;

    public WorkoutCourseTrainer(WorkoutCourseBuilder workoutCourseBuilder) {
        this.workoutCourseBuilder = workoutCourseBuilder;
    }

    public void constructWorkoutCourse(){

        workoutCourseBuilder.buildGeneralFitness();
        workoutCourseBuilder.buildMuscleGain();
        workoutCourseBuilder.buildWeightLoss();

    }

    public WorkoutCourse getWorkoutCourse() {
        return workoutCourseBuilder.getWorkoutCourse();
    }
}
