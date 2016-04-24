package com.example.hoossenlenovo.assignment6.designPatterns.factories;

import com.example.hoossenlenovo.assignment6.designPatterns.domain.Login;

/**
 * Created by hoossenLenovo on 2016-04-17.
 */
public interface LoginFactory {

    Login createLogin(String userName, String password);
}
