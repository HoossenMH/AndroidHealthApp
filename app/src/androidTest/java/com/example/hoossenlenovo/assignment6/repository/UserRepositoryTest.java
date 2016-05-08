package com.example.hoossenlenovo.assignment6.repository;

import android.test.AndroidTestCase;

import com.example.hoossenlenovo.assignment6.designPatterns.domain.User;
import com.example.hoossenlenovo.assignment6.designPatterns.domain.UserName;
import com.example.hoossenlenovo.assignment6.repository.impl.UserRepositoryImpl;

import junit.framework.Assert;

import java.util.Set;

/**
 * Created by hoossenLenovo on 2016-04-24.
 */
public class UserRepositoryTest extends AndroidTestCase
{
    private static final String TAG="User TEST";
    private Long id;


    public void testCreateReadUpdateDelete() throws Exception {
        UserRepository repo = new UserRepositoryImpl(this.getContext());
        // CREATE
        User createEntity = new User.Builder()
                .userId("001")
                .age(23)
                .build();

    User insertedEntity = repo.save(createEntity);
        id=insertedEntity.getId();
        Assert.assertNotNull(TAG+" CREATE",insertedEntity);

        //READ ALL
        Set<User> users = repo.findAll();
        Assert.assertTrue(TAG+" READ ALL",users.size()>0);

        //READ ENTITY
        User entity = repo.findById(id);
        Assert.assertNotNull(TAG+" READ ENTITY",entity);



        //UPDATE ENTITY
        User updateEntity = new User.Builder()
                .copy(entity)
                .age(22)
                .build();
        repo.update(updateEntity);
        User newEntity = repo.findById(id);
        Assert.assertEquals(TAG+ " UPDATE ENTITY",22,newEntity.getAge());

        // DELETE ENTITY
        repo.delete(updateEntity);
        User deletedEntity = repo.findById(id);
        Assert.assertNull(TAG+" DELETE",deletedEntity);

    }
}
