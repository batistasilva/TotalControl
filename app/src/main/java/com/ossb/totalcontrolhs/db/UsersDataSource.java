package com.ossb.totalcontrolhs.db;

/**
 * Created by batista on 13/05/16.
 * 1.1 Boolean Datatype
 * <p>
 * SQLite does not have a separate Boolean storage class. Instead, Boolean values are stored as integers 0 (false) and 1 (true).
 * 1.2 Date and Time Datatype
 * <p>
 * SQLite does not have a storage class set aside for storing dates and/or times. Instead, the built-in Date And Time Functions of SQLite are capable of storing dates and times as TEXT, REAL, or INTEGER values:
 * <p>
 * TEXT as ISO8601 strings ("YYYY-MM-DD HH:MM:SS.SSS").
 * REAL as Julian day numbers, the number of days since noon in Greenwich on November 24, 4714 B.C. according to the proleptic Gregorian calendar.
 * INTEGER as Unix Time, the number of seconds since 1970-01-01 00:00:00 UTC.
 * <p>
 * Applications can chose to store dates and times in any of these formats and freely convert between formats using the built-in date and time functions.
 * 2.0 Type Affinity
 * <p>
 * In order to maximize compatibility between SQLite and other database engines, SQLite supports the concept of "type affinity" on columns. The type affinity of a column is the recommended type for data stored in that column. The important idea here is that the type is recommended, not required. Any column can still store any type of data. It is just that some columns, given the choice, will prefer to use one storage class over another. The preferred storage class for a column is called its "affinity".
 * <p>
 * Each column in an SQLite 3 database is assigned one of the following type affinities:
 * <p>
 * TEXT
 * NUMERIC
 * INTEGER
 * REAL
 * BLOB
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.ossb.totalcontrolhs.model.User;
import com.ossb.totalcontrolhs.util.Security;

import java.util.ArrayList;
import java.util.List;

public class UsersDataSource {
    public static final String LOGTAG = "USERS";
    public static final String STRING_KEY = "1234567891234567";
    String vname, vemail, vuser, vpass;
    Security sec;
    SQLiteOpenHelper dbhelper;
    SQLiteDatabase database;

    private static final String[] allColumns = {
            UsersDBOpenHelper.COLUMN_ID,
            UsersDBOpenHelper.COLUMN_NAME,
            UsersDBOpenHelper.COLUMN_EMAIL,
            UsersDBOpenHelper.COLUMN_USER,
            UsersDBOpenHelper.COLUMN_PASS,
            UsersDBOpenHelper.COLUMN_CREAT,
            UsersDBOpenHelper.COLUMN_UPDATE};

    public UsersDataSource(Context context) {
        dbhelper = new UsersDBOpenHelper(context);
    }

    public void open() {
        Log.i(LOGTAG, "Database opened");
        database = dbhelper.getWritableDatabase();
    }

    public void close() {
        Log.i(LOGTAG, "Database closed");
        dbhelper.close();
    }

    /***
     * Method to add new User to table User
     * @param user
     * @return user with ID
     */
    public User create(User user) {
        ContentValues values = new ContentValues();
        //
        values.put(UsersDBOpenHelper.COLUMN_NAME, user.getName());
        values.put(UsersDBOpenHelper.COLUMN_EMAIL, user.getEmail());
        values.put(UsersDBOpenHelper.COLUMN_USER, user.getUsername());
        values.put(UsersDBOpenHelper.COLUMN_PASS, user.getPassword());
        values.put(UsersDBOpenHelper.COLUMN_CREAT, user.getDatecreat());
        //
        long insertid = database.insert(UsersDBOpenHelper.TABLE_USER, null, values);
        user.setId(insertid);
        //
        return user;
    }

    public List<User> findAll() {
        //
        Cursor cursor = database.query(UsersDBOpenHelper.TABLE_USER, allColumns,
                null, null, null, null, null);

        Log.i(LOGTAG, "Returned " + cursor.getCount() + " rows");
        List<User> users = cursorToList(cursor);
        //
        return users;
    }

    public List<User> findFiltered(String selection, String orderBy) {
        //
        Cursor cursor = database.query(UsersDBOpenHelper.TABLE_USER, allColumns,
                selection, null, null, null, orderBy);

        Log.i(LOGTAG, "Returned " + cursor.getCount() + " rows");
        List<User> users = cursorToList(cursor);
        //
        return users;
    }

    private List<User> cursorToList(Cursor cursor) {
        List<User> users = new ArrayList<User>();

        if (cursor.getCount() > 0) {
            sec = new Security();
            //
            while (cursor.moveToNext()) {
                User user = new User();
                //
                user.setId(cursor.getLong(cursor.getColumnIndex(UsersDBOpenHelper.COLUMN_ID)));
                vname = cursor.getString(cursor.getColumnIndex(UsersDBOpenHelper.COLUMN_NAME));
                user.setName(sec.decrypt(vname, STRING_KEY));
                vemail = cursor.getString(cursor.getColumnIndex(UsersDBOpenHelper.COLUMN_EMAIL));
                user.setEmail(sec.decrypt(vemail, STRING_KEY));
                vuser = cursor.getString(cursor.getColumnIndex(UsersDBOpenHelper.COLUMN_USER));
                user.setUsername(sec.decrypt(vuser, STRING_KEY));
                vpass = cursor.getString(cursor.getColumnIndex(UsersDBOpenHelper.COLUMN_PASS));
                user.setPassword(sec.decrypt(vpass, STRING_KEY));
                //
                users.add(user);
            }
        }
        return users;
    }
}
