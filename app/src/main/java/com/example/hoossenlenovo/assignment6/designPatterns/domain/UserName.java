package com.example.hoossenlenovo.assignment6.designPatterns.domain;

import java.io.Serializable;

/**
 * Created by Toshiba on 2016/04/07.
 */
public class UserName implements Serializable
{
    private Long id;
    private String firstName;
    private String lastName;

    private static final long serialVersionUID = 1L;

    public UserName()
    {}

    public UserName(Long id,String firstName, String lastName)
    {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }
    public Long getId() {
        return id;
    }
    public String getFirstName() { return firstName; }
    public String getLastName() {
        return lastName;
    }



    public UserName(Builder builder)
    {
        this.id = builder.id;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
    }

    public static class Builder
    {
        private Long id;
        private String firstName;
        private String lastName;

        public Builder id(Long value){
            this.id = value;
            return this;
        }
        public Builder firstName(String value){
            this.firstName = value;
            return this;
        }
        public Builder lastName(String value){
            this.lastName = value;
            return this;
        }

        public Builder copy(UserName value) {
            this.id = value.id;
            this.firstName = value.firstName;
            this.lastName = value.lastName;
            return this;
        }

        public UserName build() {
            return new UserName(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserName)) return false;

        UserName userName = (UserName) o;

        if (getId() != null ? !getId().equals(userName.getId()) : userName.getId() != null)
            return false;
        if (getFirstName() != null ? !getFirstName().equals(userName.getFirstName()) : userName.getFirstName() != null)
            return false;
        return getLastName() != null ? getLastName().equals(userName.getLastName()) : userName.getLastName() == null;

    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getFirstName() != null ? getFirstName().hashCode() : 0);
        result = 31 * result + (getLastName() != null ? getLastName().hashCode() : 0);
        return result;
    }
}
