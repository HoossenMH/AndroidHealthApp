package com.example.hoossenlenovo.assignment6.designPatterns.factories;

import com.example.hoossenlenovo.assignment6.designPatterns.domain.UserName;

/**
 * Created by hoossenLenovo on 2016-04-17.
 */
public interface UserNameFactory {

    UserName createUserName(String firstName, String lastName);

}
