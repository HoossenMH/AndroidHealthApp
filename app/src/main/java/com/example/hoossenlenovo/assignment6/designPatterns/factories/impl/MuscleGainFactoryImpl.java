package com.example.hoossenlenovo.assignment6.designPatterns.factories.impl;

import com.example.hoossenlenovo.assignment6.designPatterns.domain.MuscleGain;

import java.util.UUID;

/**
 * Created by hoossenLenovo on 2016-04-17.
 */
public class MuscleGainFactoryImpl {

    private static MuscleGainFactoryImpl factory = null;

    private  MuscleGainFactoryImpl() {
    }

    public static MuscleGainFactoryImpl getInstance(){
        if(factory ==null)
            factory = new MuscleGainFactoryImpl();
        return factory;
    }

    public MuscleGain createMuscleGain(int chestsAmount, int benchPressAmount, int inclineBenchPressAmount) {
        MuscleGain muscleGain = new MuscleGain
                .Builder()
                .benchPressAmount(benchPressAmount)
                .chestsAmount(chestsAmount)
                .inclineBenchPressAmount(inclineBenchPressAmount)
                .build();
        return muscleGain;
    }

}
