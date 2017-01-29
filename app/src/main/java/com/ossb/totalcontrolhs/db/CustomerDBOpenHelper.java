package com.ossb.totalcontrolhs.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by batista on 25/10/16.
 */

public class CustomerDBOpenHelper extends SQLiteOpenHelper {
    private static final String LOGTAG = "CUSTOMER";
    //name, email, telphone, mobilphone, whatsup, user_id;

    private static final String DATABASE_NAME = "Database.db";
    private static final int DATABASE_VERSION = 1;

    public static final String TABLE_CUSTOMER = "Customer";
    public static final String COLUMN_ID      = "id";
    public static final String COLUMN_USERID  = "user_id";
    public static final String COLUMN_NAME    = "name";
    public static final String COLUMN_EMAIL   = "email";
    public static final String COLUMN_PHONE   = "telphone";
    public static final String COLUMN_MOBIL   = "mobilphone";
    public static final String COLUMN_WHATSUP = "whatsup";
    public static final String COLUMN_STATUS  = "status";
    public static final String COLUMN_CREAT   = "created";
    public static final String COLUMN_UPDATE  = "updated";
    public static final String COLUMN_INACTIV = "inactive";

    private static final String TABLE_CREATE =
            "CREATE TABLE " + TABLE_CUSTOMER + " (" +
                    COLUMN_ID     + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_USERID + " INTEGER, " +
                    COLUMN_NAME   + " TEXT, " +
                    COLUMN_EMAIL  + " TEXT, " +
                    COLUMN_PHONE  + " TEXT, " +
                    COLUMN_MOBIL  + " TEXT, " +
                    COLUMN_WHATSUP + " TEXT, " +
                    COLUMN_STATUS + " CHAR, " +
                    COLUMN_CREAT  + " TEXT, " +
                    COLUMN_UPDATE + " TEXT, " +
                    COLUMN_INACTIV+ " TEXT " +
                    ")";

    public CustomerDBOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);
        Log.i(LOGTAG, "Customer Table has been created");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CUSTOMER);
        onCreate(db);
    }
}
