package com.example.hoossenlenovo.assignment6.designPatterns.factories;

import com.example.hoossenlenovo.assignment6.designPatterns.domain.MuscleGain;

/**
 * Created by hoossenLenovo on 2016-04-17.
 */
public interface MuscleGainFactory {

    MuscleGain createMuscleGain(int chestsAmount, int benchPressAmount, int inclineBenchPressAmount);

}
