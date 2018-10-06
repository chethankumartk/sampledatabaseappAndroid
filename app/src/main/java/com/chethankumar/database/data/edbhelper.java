package com.chethankumar.database.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by chethan on 22/6/18.
 */

public class edbhelper extends SQLiteOpenHelper {
    public static final String LOG_TAG = dbhelper.class.getSimpleName();

     private static final String DATABASE_NAME = "databasess.db";
private static final int DATABASE_VERSION = 1;
    public edbhelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {




        String SQL_CREATE_EMPLOYEE_TABLE =  "CREATE TABLE " + edbcontract.EmployeeEntry.EMPLOYEE_TABLE_NAME + " ("
                + edbcontract.EmployeeEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + edbcontract.EmployeeEntry.COLUMN_EMPLOYEE_NAME + " TEXT NOT NULL, "
                + edbcontract.EmployeeEntry.COLUMN_EMPLOYEE_LOCATION + " TEXT, "
                + edbcontract.EmployeeEntry.COLUMN_EMPLOYEE_SALARY + " INTEGER NOT NULL);";

        db.execSQL(SQL_CREATE_EMPLOYEE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}
