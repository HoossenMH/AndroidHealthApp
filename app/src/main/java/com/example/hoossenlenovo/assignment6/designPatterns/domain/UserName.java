package com.example.hoossenlenovo.assignment6.designPatterns.domain;

import java.io.Serializable;

/**
 * Created by Toshiba on 2016/04/07.
 */
public class UserName implements Serializable
{

    private String firstName;
    private String lastName;

    public UserName()
    {}

    public UserName(String firstName, String lastName)
    {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    public String getFirstName() { return firstName; }
    public String getLastName() {
        return lastName;
    }



    public UserName(Builder builder)
    {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
    }

    public static class Builder
    {
        private String firstName;
        private String lastName;


        public Builder firstName(String value){
            this.firstName = value;
            return this;
        }
        public Builder lastName(String value){
            this.lastName = value;
            return this;
        }

        public Builder copy(UserName value) {
            this.firstName = value.firstName;
            this.lastName = value.lastName;
            return this;
        }

        public UserName build() {
            return new UserName(this);
        }
    }

}
