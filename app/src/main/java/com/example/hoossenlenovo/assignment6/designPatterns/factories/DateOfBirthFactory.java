package com.example.hoossenlenovo.assignment6.designPatterns.factories;

import com.example.hoossenlenovo.assignment6.designPatterns.domain.DateOfBirth;

/**
 * Created by hoossenLenovo on 2016-04-17.
 */
public interface DateOfBirthFactory {

    DateOfBirth createDateOfBirth(int day, String month, int year);
}
