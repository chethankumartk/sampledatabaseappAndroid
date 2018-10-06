package com.chethankumar.database.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by chethan on 22/6/18.
 */

public class tdbhelper extends SQLiteOpenHelper {
    public static final String LOG_TAG = dbhelper.class.getSimpleName();

    private static final String DATABASE_NAME = "databasesss.db";
    private static final int DATABASE_VERSION = 1;
    public tdbhelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {




        String SQL_CREATE_EMPLOYEE_TABLE =  "CREATE TABLE " + tdbcontract.TeacherEntry.TEACHER_TABLE_NAME + " ("
                + tdbcontract.TeacherEntry._ID+ " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + tdbcontract.TeacherEntry.COLUMN_TEACHER_NAME + " TEXT NOT NULL, "
                + tdbcontract.TeacherEntry.COLUMN_TEACHER_LOCATION + " TEXT, "
                +tdbcontract.TeacherEntry.COLUMN_TEACHER_SALARY + " INTEGER NOT NULL);";

        db.execSQL(SQL_CREATE_EMPLOYEE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}