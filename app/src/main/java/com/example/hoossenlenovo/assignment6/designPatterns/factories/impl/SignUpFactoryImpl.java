package com.example.hoossenlenovo.assignment6.designPatterns.factories.impl;

import com.example.hoossenlenovo.assignment6.designPatterns.domain.SignUp;
import com.example.hoossenlenovo.assignment6.designPatterns.domain.User;
import com.example.hoossenlenovo.assignment6.designPatterns.factories.SignUpFactory;
import com.example.hoossenlenovo.assignment6.domain.DateOfBirth;
import com.example.hoossenlenovo.assignment6.domain.UserName;

import java.util.UUID;
/**
 * Created by hoossenLenovo on 2016-04-17.
 */
public class SignUpFactoryImpl implements SignUpFactory{

    private static SignUpFactoryImpl factory = null;

    private  SignUpFactoryImpl() {
    }
    public static SignUpFactoryImpl getInstance(){
        if(factory ==null)
            factory = new SignUpFactoryImpl();
        return factory;
    }

    public SignUp createSignUp(UserName uName, String username, String password, int age, String email, String gender, DateOfBirth dob)
    {
        SignUp  user = new SignUp
                .Builder()

                .username(UUID.randomUUID().toString())
                .age(age)
                .uName(uName)
                .password(password)
                .age(age)
                .email(email)
                .gender(gender)
                .dob(dob)

                .build();
        return user;
    }
}
