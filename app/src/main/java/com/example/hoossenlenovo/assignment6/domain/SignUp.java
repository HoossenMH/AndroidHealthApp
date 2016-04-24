package com.example.hoossenlenovo.assignment6.domain;

/**
 * Created by Toshiba on 2016/04/07.
 */
public class SignUp {

    private UserName uName;

    private String username;
    private String password;
    private int age;
    private String email;
    private String gender;

    private DateOfBirth dob;

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
}
