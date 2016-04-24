package com.example.hoossenlenovo.assignment6.designPatterns.factories;

import com.example.hoossenlenovo.assignment6.designPatterns.domain.SignUp;
import com.example.hoossenlenovo.assignment6.domain.DateOfBirth;
import com.example.hoossenlenovo.assignment6.domain.UserName;

/**
 * Created by hoossenLenovo on 2016-04-17.
 */
public interface SignUpFactory {

    SignUp createSignUp(UserName uName, String username, String password, int age, String email, String gender, DateOfBirth dob);
}