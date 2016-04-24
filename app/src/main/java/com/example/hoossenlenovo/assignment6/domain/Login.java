package com.example.hoossenlenovo.assignment6.domain;

/**
 * Created by Toshiba on 2016/04/07.
 */
public class Login {

    private String userName;
    private String password;


    public Login(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }


    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }
}
