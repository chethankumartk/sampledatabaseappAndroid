package com.chethankumar.database.data;

import android.provider.BaseColumns;

/**
 * Created by chethan on 22/6/18.
 */

public final class dbcontract {


    private dbcontract() {
    }


    public static final class StudentEntry implements BaseColumns {

        public final static String STUDENT_TABLE_NAME = "Student";

        public final static String _ID = BaseColumns._ID;


        public final static String COLUMN_NAME = "name";

        public final static String COLUMN_LOCATION = "location";

        public final static String COLUMN_MARKS = "marks";

    }


}

