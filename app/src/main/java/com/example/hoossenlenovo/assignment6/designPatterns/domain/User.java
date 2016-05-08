package com.example.hoossenlenovo.assignment6.designPatterns.domain;

import com.example.hoossenlenovo.assignment6.domain.CloneObject;
import com.example.hoossenlenovo.assignment6.domain.UserName;

import java.io.Serializable;
/**
 * Created by Toshiba on 2016/04/07.
 */
public class User implements CloneObject, Serializable
{
    private Long id;
    private String userId;
    private int age;
    private UserName uName;

    private static final long serialVersionUID = 1L;

    public User()
    {

    }

    public User(Long id, String userId, int age, UserName uName) {
        this.id = id;
        this.userId = userId;
        this.age = age;
        this.uName = uName;
    }


    public int getAge() {
        return age;
    }
    public String getUserId() {   return userId;  }
    public Long getId() {
        return id;
    }
    public UserName getUserName() {
        return uName;
    }

    @Override
    public CloneObject createCopy()
    {
        return new User(id,userId,age,uName);
    }



    public User(Builder builder)
    {
        this.id = builder.id;
        this.userId = builder.userId;
        this.age = builder.age;
        this.uName = builder.uName;
    }

    public static class Builder
    {
        private Long id;
        private String userId;
        private int age;
        public UserName uName;

        public Builder id(Long value){
            this.id = value;
            return this;
        }
        public Builder userId(String value){
            this.userId = value;
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
            this.userId = value.userId;
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

        User user = (User) o;

        if (getAge() != user.getAge()) return false;
        if (getId() != null ? !getId().equals(user.getId()) : user.getId() != null) return false;
        if (getUserId() != null ? !getUserId().equals(user.getUserId()) : user.getUserId() != null)
            return false;
        return uName != null ? uName.equals(user.uName) : user.uName == null;

    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getUserId() != null ? getUserId().hashCode() : 0);
        result = 31 * result + getAge();
        result = 31 * result + (uName != null ? uName.hashCode() : 0);
        return result;
    }
}
