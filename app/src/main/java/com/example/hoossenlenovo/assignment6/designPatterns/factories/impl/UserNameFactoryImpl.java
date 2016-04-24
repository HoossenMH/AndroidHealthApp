package com.example.hoossenlenovo.assignment6.designPatterns.factories.impl;

import com.example.hoossenlenovo.assignment6.designPatterns.domain.UserName;

import java.util.UUID;

/**
 * Created by hoossenLenovo on 2016-04-17.
 */
public class UserNameFactoryImpl {

    private static UserNameFactoryImpl factory = null;

    private  UserNameFactoryImpl() {
    }

    public static UserNameFactoryImpl getInstance(){
        if(factory ==null)
            factory = new UserNameFactoryImpl();
        return factory;
    }

    public UserName createUserName(String firstName, String lastName) {
        UserName userName = new UserName
                .Builder()
                .firstName(firstName)
                .lastName(lastName)
                .build();
        return userName;
    }

}
