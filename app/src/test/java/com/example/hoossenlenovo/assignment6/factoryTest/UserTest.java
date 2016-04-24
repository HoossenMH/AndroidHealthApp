package com.example.hoossenlenovo.assignment6.factoryTest;

import com.example.hoossenlenovo.assignment6.designPatterns.domain.User;
import com.example.hoossenlenovo.assignment6.designPatterns.factories.UserFactory;
import com.example.hoossenlenovo.assignment6.designPatterns.factories.impl.UserFactoryImpl;
import com.example.hoossenlenovo.assignment6.domain.UserName;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Toshiba on 2016/04/07.
 */
public class UserTest {

    private UserFactory factory;
    private UserName uName;

    @Before
    public void setUp() throws Exception {
        factory = UserFactoryImpl.getInstance();

        uName = new UserName("Hasan","Hoossen");
    }

    @Test
    public void testUserCreation() throws Exception {
        User user = factory.createUser("123456", 23, uName);
        Assert.assertEquals(user.getUserName(), uName);
        Assert.assertEquals(user.getAge(),23);
        Assert.assertNotNull(user.getId());
    }

    @Test
    public void testUserUpdate() throws Exception {
        User user = factory.createUser("123456", 23, uName);
        Assert.assertEquals(user.getUserName(), uName);
        Assert.assertEquals(user.getAge(),23);
        Assert.assertNotNull(user.getId());

        // Updated Description

        User updateUser = new User.Builder()
                .copy(user)
                .uName(uName)
                .build();

        Assert.assertEquals(updateUser.getUserName(), uName);
        Assert.assertEquals(user.getAge(),23);
        Assert.assertEquals(user.getId(),updateUser.getId());


    }

}
