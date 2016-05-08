package com.example.hoossenlenovo.assignment6.repository;

import android.test.AndroidTestCase;

import com.example.hoossenlenovo.assignment6.designPatterns.domain.Login;
import com.example.hoossenlenovo.assignment6.repository.impl.LoginRepositoryImpl;

import junit.framework.Assert;

import java.util.Set;

/**
 * Created by hoossenLenovo on 2016-04-24.
 */
public class LoginRepositoryTest extends AndroidTestCase
{
    private static final String TAG="Login TEST";
    private Long id;


    public void testCreateReadUpdateDelete() throws Exception {
        LoginRepository repo = new LoginRepositoryImpl(this.getContext());
        // CREATE
        Login createEntity = new Login.Builder()
                .userName("hhoossen")
                .password("1234")
                .build();

        Login insertedEntity = repo.save(createEntity);
        id=insertedEntity.getId();
        Assert.assertNotNull(TAG+" CREATE",insertedEntity);

        //READ ALL
        Set<Login> users = repo.findAll();
        Assert.assertTrue(TAG+" READ ALL",users.size()>0);

        //READ ENTITY
        Login entity = repo.findById(id);
        Assert.assertNotNull(TAG+" READ ENTITY",entity);

        //UPDATE ENTITY
        Login updateEntity = new Login.Builder()
                .copy(entity)
                .password("5555")
                .build();
        repo.update(updateEntity);
        Login newEntity = repo.findById(id);
        Assert.assertEquals(TAG+ " UPDATE ENTITY","5555",newEntity.getPassword());

        // DELETE ENTITY
        repo.delete(updateEntity);
        Login deletedEntity = repo.findById(id);
        Assert.assertNull(TAG+" DELETE",deletedEntity);

    }
}
