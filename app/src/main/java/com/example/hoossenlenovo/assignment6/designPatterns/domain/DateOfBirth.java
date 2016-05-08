package com.example.hoossenlenovo.assignment6.designPatterns.domain;

import java.io.Serializable;

/**
 * Created by hoossenLenovo on 2016-04-17.
 */
public class DateOfBirth implements Serializable {

    private Long id;
    private int day;
    private String month;
    private int year;

    private static final long serialVersionUID = 1L;

    public DateOfBirth() {
    }

    public DateOfBirth(Long id,int day, String month, int year) {
        this.id = id;
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public Long getId() {
        return id;
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


    public DateOfBirth(Builder builder)
    {
        this.id = builder.id;
        this.day = builder.day;
        this.month = builder.month;
        this.year = builder.year;
    }

    public static class Builder
    {
        private Long id;
        private int day;
        private String month;
        private int year;


        public Builder id(Long value){
            this.id = value;
            return this;
        }
        public Builder day(int value){
            this.day = value;
            return this;
        }
        public Builder month(String value){
            this.month = value;
            return this;
        }
        public Builder year(int value){
            this.year = value;
            return this;
        }

        public Builder copy(DateOfBirth value) {
            this.id = value.id;
            this.day = value.day;
            this.month = value.month;
            this.year = value.year;

            return this;
        }

        public DateOfBirth build() {
            return new DateOfBirth(this);
        }
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DateOfBirth)) return false;

        DateOfBirth that = (DateOfBirth) o;

        if (getDay() != that.getDay()) return false;
        if (getYear() != that.getYear()) return false;
        if (getId() != null ? !getId().equals(that.getId()) : that.getId() != null) return false;
        return getMonth() != null ? getMonth().equals(that.getMonth()) : that.getMonth() == null;

    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + getDay();
        result = 31 * result + (getMonth() != null ? getMonth().hashCode() : 0);
        result = 31 * result + getYear();
        return result;
    }
}
