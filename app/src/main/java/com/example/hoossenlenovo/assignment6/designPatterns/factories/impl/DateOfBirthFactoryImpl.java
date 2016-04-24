package com.example.hoossenlenovo.assignment6.designPatterns.factories.impl;

import com.example.hoossenlenovo.assignment6.designPatterns.domain.DateOfBirth;

import java.util.UUID;

/**
 * Created by hoossenLenovo on 2016-04-17.
 */
public class DateOfBirthFactoryImpl {

    private static DateOfBirthFactoryImpl factory = null;

    private  DateOfBirthFactoryImpl() {
    }

    public static DateOfBirthFactoryImpl getInstance(){
        if(factory ==null)
            factory = new DateOfBirthFactoryImpl();
        return factory;
    }

    public DateOfBirth createDateOfBirth(int day, String month, int year) {
        DateOfBirth dob = new DateOfBirth
                .Builder()
                .day(day)
                .month(month)
                .year(year)
                .build();
        return dob;
    }
}
