package com.example.hoossenlenovo.assignment6.repository;

import android.test.AndroidTestCase;

import com.example.hoossenlenovo.assignment6.designPatterns.domain.DateOfBirth;
import com.example.hoossenlenovo.assignment6.repository.impl.DateOfBirthRepositoryImpl;

import junit.framework.Assert;

import java.util.Set;

/**
 * Created by hoossenLenovo on 2016-04-24.
 */
public class DateOfBirthRepositoryTest extends AndroidTestCase
{
    private static final String TAG="DateOfBirth TEST";
    private Long id;


    public void testCreateReadUpdateDelete() throws Exception {
        DateOfBirthRepository repo = new DateOfBirthRepositoryImpl(this.getContext());
        // CREATE
        DateOfBirth createEntity = new DateOfBirth.Builder()
                .day(20)
                .month("Jan")
                .year(1993)
                .build();

        DateOfBirth insertedEntity = repo.save(createEntity);
        id=insertedEntity.getId();
        Assert.assertNotNull(TAG+" CREATE",insertedEntity);

        //READ ALL
        Set<DateOfBirth> users = repo.findAll();
        Assert.assertTrue(TAG+" READ ALL",users.size()>0);

        //READ ENTITY
        DateOfBirth entity = repo.findById(id);
        Assert.assertNotNull(TAG+" READ ENTITY",entity);

        //UPDATE ENTITY
        DateOfBirth updateEntity = new DateOfBirth.Builder()
                .copy(entity)
                .month("Feb")
                .build();
        repo.update(updateEntity);
        DateOfBirth newEntity = repo.findById(id);
        Assert.assertEquals(TAG+ " UPDATE ENTITY","Feb",newEntity.getMonth());

        // DELETE ENTITY
        repo.delete(updateEntity);
        DateOfBirth deletedEntity = repo.findById(id);
        Assert.assertNull(TAG+" DELETE",deletedEntity);

    }
}
