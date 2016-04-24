package com.example.hoossenlenovo.assignment6.factoryTest;

import com.example.hoossenlenovo.assignment6.designPatterns.domain.DateOfBirth;
import com.example.hoossenlenovo.assignment6.designPatterns.factories.DateOfBirthFactory;
import com.example.hoossenlenovo.assignment6.designPatterns.factories.impl.DateOfBirthFactoryImpl;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by hoossenLenovo on 2016-04-17.
 */
public class DateOfBirthTest {

    private DateOfBirthFactory factory;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testLoginCreation() throws Exception {

        DateOfBirth dateOfBirth = factory.createDateOfBirth(20 ,"Feb",1993);

        Assert.assertEquals(dateOfBirth.getDay(), 20);
        Assert.assertEquals(dateOfBirth.getMonth(), "Feb");
        Assert.assertEquals(dateOfBirth.getYear(), 1993);
    }


    @Test
    public void testLoginUpdate() throws Exception {

        DateOfBirth dateOfBirth = factory.createDateOfBirth(20, "Feb", 1993);

        Assert.assertEquals(dateOfBirth.getDay(), 20);
        Assert.assertEquals(dateOfBirth.getMonth(), "Feb");
        Assert.assertEquals(dateOfBirth.getYear(), 1993);

        // Updated day

        DateOfBirth updateDateOfBirth = new DateOfBirth.Builder()
                .copy(dateOfBirth)
                .day(21)
                .build();

        Assert.assertEquals(updateDateOfBirth.getDay(), 21);
        Assert.assertEquals(dateOfBirth.getMonth(), "Feb");
        Assert.assertEquals(dateOfBirth.getYear(), 1993);


    }
}
