package com.example.hoossenlenovo.assignment6.factoryTest;

import com.example.hoossenlenovo.assignment6.designPatterns.domain.UserName;
import com.example.hoossenlenovo.assignment6.designPatterns.factories.UserNameFactory;
import com.example.hoossenlenovo.assignment6.designPatterns.factories.impl.UserNameFactoryImpl;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by hoossenLenovo on 2016-04-17.
 */
public class UserNameTest {

    private UserNameFactory factory;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void testUserNameCreation() throws Exception {

        UserName userName = factory.createUserName("hasan", "hoossen");

        Assert.assertEquals(userName.getFirstName(), "hasan");
        Assert.assertEquals(userName.getLastName(), "hoossen");
    }


    @Test
    public void testLoginUpdate() throws Exception {

        UserName userName = factory.createUserName("hasan", "hoossen");

        Assert.assertEquals(userName.getFirstName(), "hasan");
        Assert.assertEquals(userName.getLastName(), "hoossen");

        // Updated firstName

        UserName updateUserName = new UserName.Builder()
                .copy(userName)
                .firstName("muhammad")
                .build();

        Assert.assertEquals(updateUserName.getFirstName(), "muhammad");
        Assert.assertEquals(userName.getLastName(), "hoossen");


    }
}
