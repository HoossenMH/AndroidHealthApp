package com.example.hoossenlenovo.assignment6.factoryTest;

import com.example.hoossenlenovo.assignment6.designPatterns.domain.Login;
import com.example.hoossenlenovo.assignment6.designPatterns.factories.LoginFactory;
import com.example.hoossenlenovo.assignment6.designPatterns.factories.impl.LoginFactoryImpl;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by hoossenLenovo on 2016-04-17.
 */
public class LoginTest {

    private LoginFactory factory;

    @Before
    public void setUp() throws Exception {
        factory = LoginFactoryImpl.getInstance();

    }

    @Test
    public void testLoginCreation() throws Exception {

        Login user = factory.createLogin("hhoosen", "1234");

        Assert.assertEquals(user.getUserName(), "hhoossen");
        Assert.assertEquals(user.getPassword(), "1234");
    }


    @Test
    public void testLoginUpdate() throws Exception {

        Login user = factory.createLogin("hhoosen", "1234");

        Assert.assertEquals(user.getUserName(), "hhoossen");
        Assert.assertEquals(user.getPassword(), "1234");

        // Updated password

        Login updateLogin = new Login.Builder()
                .copy(user)
                .password("0000")
                .build();

        Assert.assertEquals(user.getUserName(), "hhoossen");
        Assert.assertEquals(updateLogin.getPassword(), "0000");


    }
}
