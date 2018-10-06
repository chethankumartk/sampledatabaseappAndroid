package com.chethankumar.database.data;

import android.provider.BaseColumns;

/**
 * Created by chethan on 22/6/18.
 */

public final class tdbcontract {


    private tdbcontract() {
    }


    public static final class TeacherEntry implements BaseColumns {

        public final static String TEACHER_TABLE_NAME = "Teacher";

        public final static String _ID = BaseColumns._ID;


        public final static String COLUMN_TEACHER_NAME = "Tname";

        public final static String COLUMN_TEACHER_LOCATION = "Tlocation";

        public final static String COLUMN_TEACHER_SALARY = "Tsalary";

    }


}