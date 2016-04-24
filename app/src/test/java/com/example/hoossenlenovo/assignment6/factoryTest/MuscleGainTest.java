package com.example.hoossenlenovo.assignment6.factoryTest;

import com.example.hoossenlenovo.assignment6.designPatterns.domain.MuscleGain;
import com.example.hoossenlenovo.assignment6.designPatterns.factories.MuscleGainFactory;
import com.example.hoossenlenovo.assignment6.designPatterns.factories.impl.MuscleGainFactoryImpl;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by hoossenLenovo on 2016-04-17.
 */
public class MuscleGainTest {

    private MuscleGainFactory factory;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testMuscleGainCreation() throws Exception {

        MuscleGain muscleGain = factory.createMuscleGain(3, 3, 3);

        Assert.assertEquals(muscleGain.getBenchPressAmount(), 3);
        Assert.assertEquals(muscleGain.getChestsAmount(), 3);
        Assert.assertEquals(muscleGain.getInclineBenchPressAmount(), 3);
    }


    @Test
    public void testMuscleGainUpdate() throws Exception {

        MuscleGain muscleGain = factory.createMuscleGain(3, 3, 3);

        Assert.assertEquals(muscleGain.getBenchPressAmount(), 3);
        Assert.assertEquals(muscleGain.getChestsAmount(), 3);
        Assert.assertEquals(muscleGain.getInclineBenchPressAmount(), 3);

        // Updated ChestsAmount

        MuscleGain updateMuscleGain = new MuscleGain.Builder()
                .copy(muscleGain)
                .chestsAmount(4)
                .build();

        Assert.assertEquals(muscleGain.getBenchPressAmount(), 3);
        Assert.assertEquals(updateMuscleGain.getChestsAmount(), 4);
        Assert.assertEquals(muscleGain.getInclineBenchPressAmount(), 3);


    }
}
