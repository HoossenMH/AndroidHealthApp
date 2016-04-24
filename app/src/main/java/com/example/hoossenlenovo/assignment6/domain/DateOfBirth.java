package com.example.hoossenlenovo.assignment6.domain;

/**
 * Created by hoossenLenovo on 2016-04-17.
 */
public class DateOfBirth {

    private int day;
    private String month;
    private int year;

    public DateOfBirth() {
    }

    public DateOfBirth(int day, String month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int getDay() {
        return day;
    }

    public String getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }
}
