package com.example.hoossenlenovo.assignment6.repository;

import android.test.AndroidTestCase;

import com.example.hoossenlenovo.assignment6.designPatterns.domain.UserName;
import com.example.hoossenlenovo.assignment6.repository.impl.UserNameRepositoryImpl;

import junit.framework.Assert;

import java.util.Set;

/**
 * Created by hoossenLenovo on 2016-04-24.
 */
public class UserNameRepositoryTest extends AndroidTestCase
{
    private static final String TAG="UserName TEST";
    private Long id;


    public void testCreateReadUpdateDelete() throws Exception {
        UserNameRepository repo = new UserNameRepositoryImpl(this.getContext());
        // CREATE
        UserName createEntity = new UserName.Builder()
                .firstName("hasan")
                .lastName("hoossen")
                .build();

        UserName insertedEntity = repo.save(createEntity);
        id=insertedEntity.getId();
        Assert.assertNotNull(TAG+" CREATE",insertedEntity);

        //READ ALL
        Set<UserName> users = repo.findAll();
        Assert.assertTrue(TAG+" READ ALL",users.size()>0);

        //READ ENTITY
        UserName entity = repo.findById(id);
        Assert.assertNotNull(TAG+" READ ENTITY",entity);

        //UPDATE ENTITY
        UserName updateEntity = new UserName.Builder()
                .copy(entity)
                .lastName("Hoosain")
                .build();
        repo.update(updateEntity);
        UserName newEntity = repo.findById(id);
        Assert.assertEquals(TAG+ " UPDATE ENTITY","Hoosain",newEntity.getLastName());

        // DELETE ENTITY
        repo.delete(updateEntity);
        UserName deletedEntity = repo.findById(id);
        Assert.assertNull(TAG+" DELETE",deletedEntity);

    }
}
