package com.example.hoossenlenovo.assignment6.designPatterns.factories.impl;

import com.example.hoossenlenovo.assignment6.designPatterns.domain.Login;
import com.example.hoossenlenovo.assignment6.designPatterns.factories.LoginFactory;

import java.util.UUID;

/**
 * Created by hoossenLenovo on 2016-04-17.
 */
public class LoginFactoryImpl implements LoginFactory {

    private static LoginFactoryImpl factory = null;

    private  LoginFactoryImpl() {
    }

    public static LoginFactoryImpl getInstance(){
        if(factory ==null)
            factory = new LoginFactoryImpl();
        return factory;
    }

    public Login createLogin(String userName, String password) {
        Login user = new Login
                .Builder()
                .userName(UUID.randomUUID().toString())
                .password(password)
                .build();
        return user;
    }

}
