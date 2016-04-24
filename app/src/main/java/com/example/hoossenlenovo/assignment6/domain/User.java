package com.example.hoossenlenovo.assignment6.domain;

/**
 * Created by Toshiba on 2016/04/07.
 */
public class User implements CloneObject
{
    private String id;
    private int age;
    private UserName uName;


    public User()
    {
    }

    public User(String id, int age, UserName uName)
    {
        this.id = id;
        this.age = age;
        this.uName = uName;
    }


    public int getAge() {
        return age;
    }

    public String getId() {
        return id;
    }
    public UserName getUserName() {
        return uName;
    }

    @Override
    public CloneObject createCopy()
    {
        return  new User(id,age,uName);
    }

}
