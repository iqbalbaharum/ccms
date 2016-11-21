package com.primeitx.ccms.util.database.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by iQBAL on 14/6/2016.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String TAG = "DATABASE";

    private static final int DB_VERSION = 1;
    public static final String DB_NAME = "ccms";
    // SQL Command
    private static final String SQL_DROP_TABLE = "DROP TABLE IF EXISTS ";

    // tables
    private String[] mTables = {
    };

    // creates
    private String[] mTablesCreate = {
    };


    public static DatabaseHelper sInstance;

    /**
     * Singleton method to prevent memory leak
     * @param context
     * @return
     */
    public static synchronized DatabaseHelper getInstance(Context context) {

        if (sInstance == null) {
            sInstance = new DatabaseHelper(context.getApplicationContext());
        }

        return sInstance;
    }

    /**
     * Create a helper object to create, open, and/or manage a database.
     * This method always returns very quickly.  The database is not actually
     * created or opened until one of {@link #getWritableDatabase} or
     * {@link #getReadableDatabase} is called.
     *
     * @param context to use to open or create the database
     */
    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        createTables(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // drop old tables and create a new tables
        dropTables(db);
        createTables(db);
    }

    /***
     * Create all tables
     * @param db
     */
    private void createTables(SQLiteDatabase db) {

        for (String table : mTablesCreate) {
            db.execSQL(table);
        }
    }

    /***
     * drop all tables
     * @param db
     */
    private void dropTables(SQLiteDatabase db) {

        for (String table : mTables) {
            db.execSQL(SQL_DROP_TABLE + table);
        }
    }
}
