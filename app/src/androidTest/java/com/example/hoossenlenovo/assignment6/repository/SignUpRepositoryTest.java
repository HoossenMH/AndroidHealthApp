package com.example.hoossenlenovo.assignment6.repository;

import android.test.AndroidTestCase;

import com.example.hoossenlenovo.assignment6.designPatterns.domain.SignUp;
import com.example.hoossenlenovo.assignment6.repository.impl.SignUpRepositoryImpl;

import junit.framework.Assert;

import java.util.Set;

/**
 * Created by hoossenLenovo on 2016-04-24.
 */
public class SignUpRepositoryTest extends AndroidTestCase
{
    private static final String TAG="SignUp TEST";
    private Long id;


    public void testCreateReadUpdateDelete() throws Exception {
        SignUpRepository repo = new SignUpRepositoryImpl(this.getContext());
        // CREATE
        SignUp createEntity = new SignUp.Builder()
                .username("hhoossen")
                .password("1234")
                .age(23)
                .email("ghasan16@gmail.com")
                .gender("male")
                .build();

        SignUp insertedEntity = repo.save(createEntity);
        id=insertedEntity.getId();
        Assert.assertNotNull(TAG+" CREATE",insertedEntity);

        //READ ALL
        Set<SignUp> users = repo.findAll();
        Assert.assertTrue(TAG+" READ ALL",users.size()>0);

        //READ ENTITY
        SignUp entity = repo.findById(id);
        Assert.assertNotNull(TAG+" READ ENTITY",entity);

        //UPDATE ENTITY
        SignUp updateEntity = new SignUp.Builder()
                .copy(entity)
                .password("5555")
                .build();
        repo.update(updateEntity);
        SignUp newEntity = repo.findById(id);
        Assert.assertEquals(TAG+ " UPDATE ENTITY","5555",newEntity.getPassword());

        // DELETE ENTITY
        repo.delete(updateEntity);
        SignUp deletedEntity = repo.findById(id);
        Assert.assertNull(TAG+" DELETE",deletedEntity);

    }
}

