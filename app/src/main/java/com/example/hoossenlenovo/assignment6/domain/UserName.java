package com.example.hoossenlenovo.assignment6.domain;

/**
 * Created by Toshiba on 2016/04/07.
 */
public class UserName
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


    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
