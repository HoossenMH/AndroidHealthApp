package com.example.hoossenlenovo.assignment6.repository.impl;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.hoossenlenovo.assignment6.conf.database.DBConstants;
import com.example.hoossenlenovo.assignment6.designPatterns.domain.DateOfBirth;
import com.example.hoossenlenovo.assignment6.repository.DateOfBirthRepository;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by hoossenLenovo on 2016-04-24.
 */
public class DateOfBirthRepositoryImpl extends SQLiteOpenHelper implements DateOfBirthRepository
{
    public static final String TABLE_NAME = "DateOFBirth";
    private SQLiteDatabase db;

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_DAY = "day";
    public static final String COLUMN_MONTH = "month";
    public static final String COLUMN_YEAR = "year";

    // Database creation sql statement
    private static final String DATABASE_CREATE = " CREATE TABLE "
            + TABLE_NAME + "("
            + COLUMN_ID + " INTEGER  PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_DAY + " TEXT NOT NULL  , "
            + COLUMN_MONTH + " TEXT NOT NULL ), "
            + COLUMN_YEAR + " TEXT NOT NULL ";

    public DateOfBirthRepositoryImpl(Context context) {
        super(context, DBConstants.DATABASE_NAME, null, DBConstants.DATABASE_VERSION);
    }
    public void open() throws SQLException {
        db = this.getWritableDatabase();
    }
    public void close() {
        this.close();
    }


    @Override
    public DateOfBirth findById(Long id) {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(
                TABLE_NAME,
                new String[]{
                        COLUMN_ID,
                        COLUMN_DAY,
                        COLUMN_MONTH,
                        COLUMN_YEAR},
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(id)},
                null,
                null,
                null);
        if (cursor.moveToFirst()) {
            final DateOfBirth dateOfBirth = new DateOfBirth.Builder()
                    .id(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                    .day(cursor.getInt(cursor.getColumnIndex(COLUMN_DAY)))
                    .month(cursor.getString(cursor.getColumnIndex(COLUMN_MONTH)))
                    .year(cursor.getInt(cursor.getColumnIndex(COLUMN_YEAR)))
                    .build();

            return dateOfBirth;
        } else {
            return null;
        }
    }

    @Override
    public DateOfBirth save(DateOfBirth entity) {
        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, entity.getId());
        values.put(COLUMN_DAY, entity.getDay());
        values.put(COLUMN_MONTH, entity.getMonth());
        values.put(COLUMN_YEAR, entity.getYear());
        long id = db.insertOrThrow(TABLE_NAME, null, values);

        DateOfBirth insertedEntity = new DateOfBirth.Builder()
                .copy(entity)
                .id(new Long(id))
                .build();
        return insertedEntity;
    }

    @Override
    public DateOfBirth update(DateOfBirth entity) {
        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, entity.getId());
        values.put(COLUMN_DAY, entity.getDay());
        values.put(COLUMN_MONTH, entity.getMonth());
        values.put(COLUMN_YEAR, entity.getYear());
        db.update(
                TABLE_NAME,
                values,
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(entity.getId())}
        );
        return entity;
    }


    @Override
    public Set<DateOfBirth> findAll() {
        SQLiteDatabase db = this.getReadableDatabase();
        Set<DateOfBirth> dateOfBirths = new HashSet<>();
        open();
        Cursor cursor = db.query(TABLE_NAME, null,null,null,null,null,null);
        if (cursor.moveToFirst()) {
            do {
                final DateOfBirth dateOfBirth = new DateOfBirth.Builder()
                        .id(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                        .day(cursor.getInt(cursor.getColumnIndex(COLUMN_DAY)))
                        .month(cursor.getString(cursor.getColumnIndex(COLUMN_MONTH)))
                        .year(cursor.getInt(cursor.getColumnIndex(COLUMN_YEAR)))
                        .build();
                dateOfBirths.add(dateOfBirth);
            } while (cursor.moveToNext());
        }
        return dateOfBirths;
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
    public DateOfBirth delete(DateOfBirth entity) {
        return entity;
    }
}
