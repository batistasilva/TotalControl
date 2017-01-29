package com.ossb.totalcontrolhs.db;

/**
 * Created by batista on 13/05/16.
 */
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class UsersDBOpenHelper extends SQLiteOpenHelper {

    private static final String LOGTAG = "USERS";

    private static final String DATABASE_NAME = "Database.db";
    private static final int DATABASE_VERSION = 1;

    public static final String TABLE_USER    = "User";
    public static final String COLUMN_ID     = "id";
    public static final String COLUMN_NAME   = "name";
    public static final String COLUMN_EMAIL  = "email";
    public static final String COLUMN_STATUS = "status";
    public static final String COLUMN_USER   = "username";
    public static final String COLUMN_PASS   = "password";
    public static final String COLUMN_CREAT  = "created";
    public static final String COLUMN_UPDATE = "updated";
    public static final String COLUMN_INACTIV= "inactive";

    private static final String TABLE_CREATE =
            "CREATE TABLE " + TABLE_USER + " (" +
                    COLUMN_ID     + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_NAME   + " TEXT, " +
                    COLUMN_EMAIL  + " TEXT, " +
                    COLUMN_STATUS + " CHAR, " +
                    COLUMN_USER   + " TEXT, " +
                    COLUMN_PASS   + " TEXT, " +
                    COLUMN_CREAT  + " TEXT, " +
                    COLUMN_UPDATE + " TEXT, " +
                    COLUMN_INACTIV+ " TEXT " +
                    ")";

    public UsersDBOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);
        Log.i(LOGTAG, "User Table has been created");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USER);
        onCreate(db);
    }
}
