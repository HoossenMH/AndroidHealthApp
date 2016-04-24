package com.example.hoossenlenovo.assignment6.designPatterns.domain;

import com.example.hoossenlenovo.assignment6.domain.DateOfBirth;
import com.example.hoossenlenovo.assignment6.domain.UserName;


import java.io.Serializable;
/**
 * Created by Toshiba on 2016/04/07.
 */
public class SignUp implements Serializable{

    private UserName uName;

    private String username;
    private String password;
    private int age;
    private String email;
    private String gender;

    private DateOfBirth dob;

    private static final long serialVersionUID = 1L;

    public SignUp() {
    }

    public SignUp(UserName uName, String username, String password, int age, String email, String gender, DateOfBirth dob) {

        this.uName = uName;

        this.username = username;
        this.password = password;
        this.age = age;
        this.email = email;
        this.gender = gender;

        this.dob = dob;
    }


    public UserName getUName() {
        return uName;
    }

    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    public int getAge() {
        return age;
    }
    public String getEmail() {
        return email;
    }
    public String getGender() {
        return gender;
    }

    public DateOfBirth getDob() {
        return dob;
    }



    public SignUp(Builder builder)
    {

        this.uName = builder.uName;

        this.username = builder.username;
        this.password = builder.password;
        this.age = builder.age;
        this.email = builder.email;
        this.gender = builder.gender;

        this.dob = builder.dob;
    }


    public static class Builder
    {
        private UserName uName;

        private String username;
        private String password;
        private int age;
        private String email;
        private String gender;

        private DateOfBirth dob;


        public Builder uName(UserName value){
            this.uName = value;
            return this;
        }

        public Builder username(String value){
            this.username = value;
            return this;
        }

        public Builder password(String value){
            this.password = value;
            return this;
        }

        public Builder age(int value){
            this.age = value;
            return this;
        }

        public Builder email(String value){
            this.email = value;
            return this;
        }

        public Builder gender(String value){
            this.gender = value;
            return this;
        }

        public Builder dob(DateOfBirth value){
            this.dob = value;
            return this;
        }

        public Builder copy(SignUp value) {

            this.uName = value.uName;

            this.username = value.username;
            this.password = value.password;
            this.age = value.age;
            this.email = value.email;
            this.gender = value.gender;

            this.dob = value.dob;

            return this;
        }

        public SignUp build() {
            return new SignUp(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SignUp)) return false;

        SignUp signUp = (SignUp) o;

        if (getAge() != signUp.getAge()) return false;
        if (uName != null ? !uName.equals(signUp.uName) : signUp.uName != null) return false;
        if (getUsername() != null ? !getUsername().equals(signUp.getUsername()) : signUp.getUsername() != null)
            return false;
        if (getPassword() != null ? !getPassword().equals(signUp.getPassword()) : signUp.getPassword() != null)
            return false;
        if (getEmail() != null ? !getEmail().equals(signUp.getEmail()) : signUp.getEmail() != null)
            return false;
        if (getGender() != null ? !getGender().equals(signUp.getGender()) : signUp.getGender() != null)
            return false;
        return !(getDob() != null ? !getDob().equals(signUp.getDob()) : signUp.getDob() != null);

    }

    @Override
    public int hashCode() {
        int result = uName != null ? uName.hashCode() : 0;
        result = 31 * result + (getUsername() != null ? getUsername().hashCode() : 0);
        result = 31 * result + (getPassword() != null ? getPassword().hashCode() : 0);
        result = 31 * result + getAge();
        result = 31 * result + (getEmail() != null ? getEmail().hashCode() : 0);
        result = 31 * result + (getGender() != null ? getGender().hashCode() : 0);
        result = 31 * result + (getDob() != null ? getDob().hashCode() : 0);
        return result;
    }
}
