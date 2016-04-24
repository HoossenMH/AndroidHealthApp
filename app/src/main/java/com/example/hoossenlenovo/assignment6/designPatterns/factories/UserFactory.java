package com.example.hoossenlenovo.assignment6.designPatterns.factories;

import com.example.hoossenlenovo.assignment6.designPatterns.domain.User;
import com.example.hoossenlenovo.assignment6.domain.UserName;

/**
 * Created by Toshiba on 2016/04/07.
 */
public interface UserFactory {

    User createUser(String id, int age, UserName uName);

}
