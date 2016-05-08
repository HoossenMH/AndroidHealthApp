package com.example.hoossenlenovo.assignment6.repository.impl;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.hoossenlenovo.assignment6.conf.database.DBConstants;
import com.example.hoossenlenovo.assignment6.designPatterns.domain.User;
import com.example.hoossenlenovo.assignment6.designPatterns.domain.UserName;
import com.example.hoossenlenovo.assignment6.repository.UserRepository;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by hoossenLenovo on 2016-04-24.
 */
public class UserRepositoryImpl extends SQLiteOpenHelper implements UserRepository
{
    public static final String TABLE_NAME = "User";
    private SQLiteDatabase db;
    private UserName uName;

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_USERID = "userId";
    public static final String COLUMN_AGE = "age";
    public static final String COLUMN_USERNAME_GETFIRSTNAME = "username_getFirstname";
    public static final String COLUMN_USERNAME_GETLASTNAME = "username_getLastname";

    // Database creation sql statement
    private static final String DATABASE_CREATE = " CREATE TABLE "
            + TABLE_NAME + "("
            + COLUMN_ID + " INTEGER  PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_USERID + " TEXT UNIQUE NOT NULL , "
            + COLUMN_AGE + " TEXT NOT NULL , "
            + COLUMN_USERNAME_GETFIRSTNAME + " TEXT NOT NULL"
            + COLUMN_USERNAME_GETLASTNAME + " TEXT NOT NULL );";

    public UserRepositoryImpl(Context context) {
        super(context, DBConstants.DATABASE_NAME, null, DBConstants.DATABASE_VERSION);
    }
    public void open() throws SQLException {
        db = this.getWritableDatabase();
    }
    public void close() {
        this.close();
    }


    @Override
    public User findById(Long id) {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(
                TABLE_NAME,
                new String[]{
                        COLUMN_ID,
                        COLUMN_USERID,
                        COLUMN_AGE,
                        COLUMN_USERNAME_GETFIRSTNAME,
                        COLUMN_USERNAME_GETLASTNAME},
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(id)},
                null,
                null,
                null,
                null);
        if (cursor.moveToFirst()) {
            final User user = new User.Builder()
                    .id(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                    .userId(cursor.getString(cursor.getColumnIndex(COLUMN_USERID)))
                    .age(cursor.getInt(cursor.getColumnIndex(COLUMN_AGE)))
                    .build();

            return user;
        } else {
            return null;
        }
    }

    @Override
    public User save(User entity) {
        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, entity.getId());
        values.put(COLUMN_USERID, entity.getUserId());
        values.put(COLUMN_AGE, entity.getAge());
        values.put(COLUMN_USERNAME_GETFIRSTNAME, entity.getUserName().getFirstName());
        values.put(COLUMN_USERNAME_GETLASTNAME, entity.getUserName().getLastName());
        long id = db.insertOrThrow(TABLE_NAME, null, values);

        User insertedEntity = new User.Builder()
                .copy(entity)
                .id(new Long(id))
                .build();
        return insertedEntity;
    }

    @Override
    public User update(User entity) {
        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, entity.getId());
        values.put(COLUMN_USERID, entity.getUserId());
        values.put(COLUMN_AGE, entity.getAge());
        values.put(COLUMN_USERNAME_GETFIRSTNAME, entity.getUserName().getFirstName());
        values.put(COLUMN_USERNAME_GETLASTNAME, entity.getUserName().getLastName());
        db.update(
                TABLE_NAME,
                values,
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(entity.getId())}
        );
        return entity;
    }

    @Override
    public Set<User> findAll() {
        SQLiteDatabase db = this.getReadableDatabase();
        Set<User> users = new HashSet<>();
        open();
        Cursor cursor = db.query(TABLE_NAME, null,null,null,null,null,null);
        if (cursor.moveToFirst()) {
            do {
                final User user = new User.Builder()
                        .id(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                        .userId(cursor.getString(cursor.getColumnIndex(COLUMN_USERID)))
                        .age(cursor.getInt(cursor.getColumnIndex(COLUMN_AGE)))
                        .build();
                users.add(user);
            } while (cursor.moveToNext());
        }
        return users;
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
    public User delete(User entity) {
        return entity;
    }
}
