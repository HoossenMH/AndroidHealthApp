package com.example.hoossenlenovo.assignment6.designPatterns.domain;

import com.example.hoossenlenovo.assignment6.domain.CloneObject;
import com.example.hoossenlenovo.assignment6.domain.UserName;

import java.io.Serializable;
/**
 * Created by Toshiba on 2016/04/07.
 */
public class User implements CloneObject, Serializable
{
    private String id;
    private int age;
    private UserName uName;

    private static final long serialVersionUID = 1L;

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
        return new User(id,age,uName);
    }



    public User(Builder builder)
    {
        this.id = builder.id;
        this.age = builder.age;
        this.uName = builder.uName;
    }

    public static class Builder
    {
        private String id;
        private int age;
        private UserName uName;

        public Builder id(String value){
            this.id = value;
            return this;
        }
        public Builder age(int value){
            this.age = value;
            return this;
        }
        public Builder uName(UserName value){
            this.uName = value;
            return this;
        }

        public Builder copy(User value) {
            this.id = value.id;
            this.age = value.age;
            this.uName = value.uName;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User role = (User) o;

        if (getId() != null ? !getId().equals(role.getId()) : role.getId() != null) return false;
        if (getAge() != 0 ?  getAge() != role.getAge() : role.getAge() != 0)
            return false;
        return !(getUserName() != null ? !getUserName().equals(role.getUserName()) : role.getUserName() != null);

    }


}
