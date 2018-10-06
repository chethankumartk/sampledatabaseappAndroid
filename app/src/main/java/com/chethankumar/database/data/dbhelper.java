package com.chethankumar.database.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by chethan on 22/6/18.
 */

public class dbhelper extends SQLiteOpenHelper {

    public static final String LOG_TAG = dbhelper.class.getSimpleName();

    private static final String DATABASE_NAME = "databases.db";

    private static final int DATABASE_VERSION = 1;

    public dbhelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String SQL_CREATE_STUDENT_TABLE =  "CREATE TABLE " + dbcontract.StudentEntry.STUDENT_TABLE_NAME + " ("
                + dbcontract.StudentEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + dbcontract.StudentEntry.COLUMN_NAME + " TEXT NOT NULL, "
                + dbcontract.StudentEntry.COLUMN_LOCATION + " TEXT, "
                + dbcontract.StudentEntry.COLUMN_MARKS + " INTEGER NOT NULL);";



        db.execSQL(SQL_CREATE_STUDENT_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}
