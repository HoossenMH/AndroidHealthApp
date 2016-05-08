package com.example.hoossenlenovo.assignment6.repository.impl;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.hoossenlenovo.assignment6.conf.database.DBConstants;
import com.example.hoossenlenovo.assignment6.designPatterns.domain.MuscleGain;
import com.example.hoossenlenovo.assignment6.repository.MuscleGainRepository;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by hoossenLenovo on 2016-04-24.
 */
public class MuscleGainRepositoryImpl extends SQLiteOpenHelper implements MuscleGainRepository
{
        public static final String TABLE_NAME = "MuscleGain";
        private SQLiteDatabase db;

        public static final String COLUMN_ID = "id";
        public static final String COLUMN_CHESTAMOUNT = "chestsAmount";
        public static final String COLUMN_BENCHPRESSAMOUNT = "benchPressAmount";
        public static final String COLUMN_INCLINEBENCHPRESSAMOUNT = "inclineBenchPressAmount";


    // Database creation sql statement
    private static final String DATABASE_CREATE = " CREATE TABLE "
            + TABLE_NAME + "("
            + COLUMN_ID + " INTEGER  PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_CHESTAMOUNT + " TEXT UNIQUE NOT NULL , "
            + COLUMN_BENCHPRESSAMOUNT + " TEXT NOT NULL );"
            + COLUMN_INCLINEBENCHPRESSAMOUNT + " TEXT NOT NULL );";

    public MuscleGainRepositoryImpl(Context context) {
        super(context, DBConstants.DATABASE_NAME, null, DBConstants.DATABASE_VERSION);
    }
    public void open() throws SQLException {
        db = this.getWritableDatabase();
    }
    public void close() {
        this.close();
    }

    @Override
    public MuscleGain findById(Long id) {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(
                TABLE_NAME,
                new String[]{
                        COLUMN_ID,
                        COLUMN_CHESTAMOUNT,
                        COLUMN_BENCHPRESSAMOUNT,
                        COLUMN_INCLINEBENCHPRESSAMOUNT},
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(id)},
                null,
                null,
                null,
                null);
        if (cursor.moveToFirst()) {
            final MuscleGain muscleGain = new MuscleGain.Builder()
                    .id(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                    .chestsAmount(cursor.getInt(cursor.getColumnIndex(COLUMN_CHESTAMOUNT)))
                    .benchPressAmount(cursor.getInt(cursor.getColumnIndex(COLUMN_BENCHPRESSAMOUNT)))
                    .inclineBenchPressAmount(cursor.getInt(cursor.getColumnIndex(COLUMN_INCLINEBENCHPRESSAMOUNT)))
                    .build();

            return muscleGain;
        } else {
            return null;
        }
    }

    @Override
    public MuscleGain save(MuscleGain entity) {
        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, entity.getId());
        values.put(COLUMN_CHESTAMOUNT, entity.getChestsAmount());
        values.put(COLUMN_BENCHPRESSAMOUNT, entity.getBenchPressAmount());
        values.put(COLUMN_INCLINEBENCHPRESSAMOUNT, entity.getInclineBenchPressAmount());
        long id = db.insertOrThrow(TABLE_NAME, null, values);

        MuscleGain insertedEntity = new MuscleGain.Builder()
                .copy(entity)
                .id(new Long(id))
                .build();
        return insertedEntity;
    }

    @Override
    public MuscleGain update(MuscleGain entity) {
        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_CHESTAMOUNT, entity.getChestsAmount());
        values.put(COLUMN_BENCHPRESSAMOUNT, entity.getBenchPressAmount());
        values.put(COLUMN_INCLINEBENCHPRESSAMOUNT, entity.getInclineBenchPressAmount());
        db.update(
                TABLE_NAME,
                values,
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(entity.getId())}
        );
        return entity;
    }

    @Override
    public Set<MuscleGain> findAll() {
        SQLiteDatabase db = this.getReadableDatabase();
        Set<MuscleGain> muscleGains= new HashSet<>();
        open();
        Cursor cursor = db.query(TABLE_NAME, null,null,null,null,null,null);
        if (cursor.moveToFirst()) {
            do {
                final MuscleGain muscleGain = new MuscleGain.Builder()
                        .id(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                        .chestsAmount(cursor.getInt(cursor.getColumnIndex(COLUMN_CHESTAMOUNT)))
                        .benchPressAmount(cursor.getInt(cursor.getColumnIndex(COLUMN_BENCHPRESSAMOUNT)))
                        .inclineBenchPressAmount(cursor.getInt(cursor.getColumnIndex(COLUMN_INCLINEBENCHPRESSAMOUNT)))
                        .build();
                muscleGains.add(muscleGain);
            } while (cursor.moveToNext());
        }
        return muscleGains;
    }

    @Override
    public int deleteAll() {
        open();
        int rowsDeleted = db.delete(TABLE_NAME,null,null);
        close();
        return rowsDeleted;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(this.getClass().getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);

    }

    @Override
    public MuscleGain delete(MuscleGain entity) {
        return entity;
    }
}
