package com.example.hoossenlenovo.assignment6.repository.impl;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.hoossenlenovo.assignment6.conf.database.DBConstants;
import com.example.hoossenlenovo.assignment6.designPatterns.domain.SignUp;
import com.example.hoossenlenovo.assignment6.repository.SignUpRepository;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by hoossenLenovo on 2016-04-24.
 */
public class SignUpRepositoryImpl  extends SQLiteOpenHelper implements SignUpRepository
{
    public static final String TABLE_NAME = "SignUp";
    private SQLiteDatabase db;

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_USERNAME = "userName";
    public static final String COLUMN_PASSWORD = "password";
    public static final String COLUMN_AGE = "age";
    public static final String COLUMN_EMAIL = "email";
    public static final String COLUMN_GENDER = "gender";
   // public static final String COLUMN_DATEOFBIRTH = "dateofbirth";
   // public static final String COLUMN_UNAME = "uName";

    // Database creation sql statement
    private static final String DATABASE_CREATE = " CREATE TABLE "
            + TABLE_NAME + "("
            + COLUMN_ID + " INTEGER  PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_USERNAME + " TEXT NOT NULL  , "
            + COLUMN_PASSWORD + " TEXT NOT NULL  , "
            + COLUMN_AGE + " TEXT NOT NULL  , "
            + COLUMN_EMAIL + " TEXT NOT NULL  , "
            + COLUMN_GENDER + " TEXT NOT NULL );";
           // + COLUMN_DATEOFBIRTH + " TEXT NOT NULL  , "
           // + COLUMN_UNAME + " TEXT NOT NULL );";

    public SignUpRepositoryImpl(Context context) {
        super(context, DBConstants.DATABASE_NAME, null, DBConstants.DATABASE_VERSION);
    }
    public void open() throws SQLException {
        db = this.getWritableDatabase();
    }
    public void close() {
        this.close();
    }

    @Override
    public SignUp findById(Long id) {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(
                TABLE_NAME,
                new String[]{
                        COLUMN_ID,
                        COLUMN_USERNAME,
                        COLUMN_PASSWORD,
                        COLUMN_AGE,
                        COLUMN_EMAIL,
                        COLUMN_GENDER},
                       // COLUMN_DATEOFBIRTH,
                       // COLUMN_UNAME},
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(id)},
                null,
                null,
                null,
                null);
        if (cursor.moveToFirst()) {
            final SignUp signUp = new SignUp.Builder()
                    .id(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                    .username(cursor.getString(cursor.getColumnIndex(COLUMN_USERNAME)))
                    .password(cursor.getString(cursor.getColumnIndex(COLUMN_PASSWORD)))
                    .age(cursor.getInt(cursor.getColumnIndex(COLUMN_AGE)))
                    .email(cursor.getString(cursor.getColumnIndex(COLUMN_EMAIL)))
                    .gender(cursor.getString(cursor.getColumnIndex(COLUMN_GENDER)))
                   // .dob.toString(cursor.getString(cursor.getColumnIndex(COLUMN_DATEOFBIRTH)))
                   // .uName(cursor.getString(cursor.getColumnIndex(COLUMN_UNAME)))
                    .build();

            return signUp;
        } else {
            return null;
        }
    }



    @Override
    public SignUp save(SignUp entity) {
        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, entity.getId());
        values.put(COLUMN_USERNAME, entity.getUsername());
        values.put(COLUMN_PASSWORD, entity.getPassword());
        values.put(COLUMN_AGE, entity.getAge());
        values.put(COLUMN_EMAIL, entity.getEmail());
        values.put(COLUMN_GENDER, entity.getGender());
       // values.put(COLUMN_DATEOFBIRTH, entity.getDob().toString());
      //  values.put(COLUMN_UNAME, entity.getUName().toString());
        long id = db.insertOrThrow(TABLE_NAME, null, values);

        SignUp insertedEntity = new SignUp.Builder()
                .copy(entity)
                .id(new Long(id))
                .build();
        return insertedEntity;
    }

    @Override
    public SignUp update(SignUp entity) {
        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, entity.getId());
        values.put(COLUMN_USERNAME, entity.getUsername());
        values.put(COLUMN_PASSWORD, entity.getPassword());
        values.put(COLUMN_AGE, entity.getAge());
        values.put(COLUMN_EMAIL, entity.getEmail());
        values.put(COLUMN_GENDER, entity.getGender());
        //values.put(COLUMN_DATEOFBIRTH, entity.getDob().toString());
       // values.put(COLUMN_UNAME, entity.getUName().toString());
        db.update(
                TABLE_NAME,
                values,
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(entity.getId())}
        );
        return entity;
    }

    @Override
    public Set<SignUp> findAll() {
        SQLiteDatabase db = this.getReadableDatabase();
        Set<SignUp> signUps = new HashSet<>();
        open();
        Cursor cursor = db.query(TABLE_NAME, null,null,null,null,null,null);
        if (cursor.moveToFirst()) {
            do {
                final SignUp signUp = new SignUp.Builder()
                        .id(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                        .username(cursor.getString(cursor.getColumnIndex(COLUMN_USERNAME)))
                        .password(cursor.getString(cursor.getColumnIndex(COLUMN_PASSWORD)))
                        .age(cursor.getInt(cursor.getColumnIndex(COLUMN_AGE)))
                        .email(cursor.getString(cursor.getColumnIndex(COLUMN_EMAIL)))
                        .gender(cursor.getString(cursor.getColumnIndex(COLUMN_GENDER)))
                       // .dob(cursor.getString(cursor.getColumnIndex(COLUMN_DATEOFBIRTH)))
                        //.uName(cursor.getString(cursor.getColumnIndex(COLUMN_UNAME)))
                        .build();
                signUps.add(signUp);
            } while (cursor.moveToNext());
        }
        return signUps;
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
    public SignUp delete(SignUp entity) {
        return entity;
    }


}
