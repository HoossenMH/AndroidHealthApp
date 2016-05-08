package com.example.hoossenlenovo.assignment6.repository;

import android.test.AndroidTestCase;

import com.example.hoossenlenovo.assignment6.designPatterns.domain.MuscleGain;
import com.example.hoossenlenovo.assignment6.repository.impl.MuscleGainRepositoryImpl;

import junit.framework.Assert;

import java.util.Set;

/**
 * Created by hoossenLenovo on 2016-04-24.
 */
public class MuscleGainRepositoryTest extends AndroidTestCase
{
    private static final String TAG="MuscleGain TEST";
    private Long id;


    public void testCreateReadUpdateDelete() throws Exception {
        MuscleGainRepository repo = new MuscleGainRepositoryImpl(this.getContext());
        // CREATE
        MuscleGain createEntity = new MuscleGain.Builder()
                .chestsAmount(3)
                .benchPressAmount(4)
                .inclineBenchPressAmount(5)
                .build();

        MuscleGain insertedEntity = repo.save(createEntity);
        id=insertedEntity.getId();
        Assert.assertNotNull(TAG+" CREATE",insertedEntity);

        //READ ALL
        Set<MuscleGain> users = repo.findAll();
        Assert.assertTrue(TAG+" READ ALL",users.size()>0);

        //READ ENTITY
        MuscleGain entity = repo.findById(id);
        Assert.assertNotNull(TAG+" READ ENTITY",entity);

        //UPDATE ENTITY
        MuscleGain updateEntity = new MuscleGain.Builder()
                .copy(entity)
                .chestsAmount(6)
                .build();
        repo.update(updateEntity);
        MuscleGain newEntity = repo.findById(id);
        Assert.assertEquals(TAG+ " UPDATE ENTITY",6,newEntity.getChestsAmount());

        // DELETE ENTITY
        repo.delete(updateEntity);
        MuscleGain deletedEntity = repo.findById(id);
        Assert.assertNull(TAG+" DELETE",deletedEntity);

    }
}
