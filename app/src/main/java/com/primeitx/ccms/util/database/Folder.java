package com.primeitx.ccms.util.database;

import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

/**
 * Created by MuhammadIqbal on 30/10/2016.
 */

public class Folder extends BaseTable {

    private static final String TAG = "DBFolder";

    public static final String TABLE_NAME = "folder";

    public static abstract class ColumnEntry implements BaseColumns {
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_COUNTRY = "country";
        public static final String COLUMN_PROFILE_IMAGE = "profile_image";
    }

    String[] projections = {
            //ColumnEntry._ID,
            ColumnEntry.COLUMN_NAME,
            ColumnEntry.COLUMN_COUNTRY,
            ColumnEntry.COLUMN_PROFILE_IMAGE
    };

    public static final String DB_CREATE = "CREATE TABLE " + TABLE_NAME + "(" +
            //ColumnEntry.COLUMN_USERID + " TEXT PRIMARY KEY, " +
            ColumnEntry.COLUMN_NAME + " TEXT, " +
            ColumnEntry.COLUMN_COUNTRY + " TEXT, " +
            ColumnEntry.COLUMN_PROFILE_IMAGE + " TEXT " +
            ")";

    private SQLiteOpenHelper mHelper = null;

    public Folder(SQLiteOpenHelper helper) {
        mHelper = helper;
    }
}
