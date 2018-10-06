package com.chethankumar.database.data;

import android.provider.BaseColumns;

/**
 * Created by chethan on 22/6/18.
 */

public final class edbcontract {


    private edbcontract() {
    }


    public static final class EmployeeEntry implements BaseColumns {

        public final static String _ID = BaseColumns._ID;
     public final static String EMPLOYEE_TABLE_NAME = "Employee";
        public final static String COLUMN_EMPLOYEE_NAME = "Ename";
         public final static String COLUMN_EMPLOYEE_LOCATION = "Elocation";
        public final static String COLUMN_EMPLOYEE_SALARY = "Esalary";
    }


}

