package com.example.hoossenlenovo.assignment6.factoryTest;

import com.example.hoossenlenovo.assignment6.designPatterns.domain.SignUp;
import com.example.hoossenlenovo.assignment6.designPatterns.factories.SignUpFactory;
import com.example.hoossenlenovo.assignment6.designPatterns.factories.impl.SignUpFactoryImpl;
import com.example.hoossenlenovo.assignment6.domain.DateOfBirth;
import com.example.hoossenlenovo.assignment6.domain.UserName;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by hoossenLenovo on 2016-04-17.
 */
public class SignUpTest {

    private SignUpFactory factory;
    private UserName uName;
    private DateOfBirth dob;

    @Before
    public void setUp() throws Exception {
        factory = SignUpFactoryImpl.getInstance();

        uName = new UserName("Hasan","Hoossen");
        dob = new DateOfBirth(20, "February", 1993);
    }

    @Test
    public void testUserCreation() throws Exception {
        SignUp user = factory.createSignUp(uName, "hhoossen", "1234", 23, "ghasan16@gmail.com", "male", dob);
        Assert.assertEquals(user.getUName(), uName);
        Assert.assertEquals(user.getAge(),23);
        Assert.assertNotNull(user.getDob());
        Assert.assertNotNull(user.getEmail());
        Assert.assertNotNull(user.getGender());
        Assert.assertNotNull(user.getPassword());
        Assert.assertNotNull(user.getUsername());
    }

    @Test
    public void testUserUpdate() throws Exception {
        SignUp user = factory.createSignUp(uName, "hhoossen", "1234", 23, "ghasan16@gmail.com", "male", dob);
        Assert.assertEquals(user.getUName(), uName);
        Assert.assertEquals(user.getAge(),23);
        Assert.assertEquals(user.getDob(), dob);
        Assert.assertEquals(user.getEmail(), "ghasan16@gmail.com");
        Assert.assertEquals(user.getGender(),"male");
        Assert.assertEquals(user.getPassword(), "1234");
        Assert.assertEquals(user.getUsername(),"hhoossen");

        // Updated age

        SignUp updateUser = new SignUp.Builder()
                .copy(user)
                .age(22)
                .build();

        Assert.assertEquals(user.getUName(), uName);
        Assert.assertEquals(updateUser.getAge(),22);
        Assert.assertEquals(user.getDob(), dob);
        Assert.assertEquals(user.getEmail(), "ghasan16@gmail.com");
        Assert.assertEquals(user.getGender(),"male");
        Assert.assertEquals(user.getPassword(), "1234");
        Assert.assertEquals(user.getUsername(), "hhoossen");


    }
}
