package com.chethankumar.database;


import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.chethankumar.database.data.dbcontract;
import com.chethankumar.database.data.dbhelper;
import com.chethankumar.database.data.edbcontract;
import com.chethankumar.database.data.edbhelper;
import com.chethankumar.database.data.tdbcontract;
import com.chethankumar.database.data.tdbhelper;


/**
 * A simple {@link Fragment} subclass.
 */
public class insert extends Fragment {
    String[] arr = {"Student", "Employee", "Teacher"};
    TextView tv;
    EditText Name, Location, Marks;
    Button butsub,rest;


    public insert() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_insert, container, false);
        tv = (TextView) inflate.findViewById(R.id.check);
        Name = (EditText) inflate.findViewById(R.id.name);

        Location = (EditText) inflate.findViewById(R.id.location);
        Marks = (EditText) inflate.findViewById(R.id.marks);
        butsub=(Button)inflate.findViewById(R.id.submit);
        rest=(Button)inflate.findViewById(R.id.reset);


        Spinner spin = (Spinner) inflate.findViewById(R.id.spinnerr);
        ArrayAdapter aa = new ArrayAdapter(getActivity(), android.R.layout.simple_spinner_item, arr);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(aa);


        spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                gettext(arr[i]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        butsub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String t=tv.getText().toString();
                String select1 = "Student";
                String select2="Employee";
                String select3="Teacher";
                if(t.equalsIgnoreCase(select1))
                {
                    insertStudent();
                }
                if(t.equalsIgnoreCase(select2))
                {
                    Toast.makeText(getContext(),t, Toast.LENGTH_LONG).show();
                    insertEmployee();

                }
                if(t.equalsIgnoreCase(select3))
                {
                    Toast.makeText(getContext(),t, Toast.LENGTH_LONG).show();
                    insertTeacher();
                }

            }
        });
        rest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteall();
            }
        });

        return inflate;


    }

    public void gettext(String country) {
        tv.setText(country);

    }


    private void insertStudent() {
        String nameString = Name.getText().toString().trim();
        String locationString = Location.getText().toString().trim();
        String marksString = Marks.getText().toString().trim();
        int marks = Integer.parseInt(marksString);

        dbhelper mDbHelper = new dbhelper(getActivity());

        SQLiteDatabase db = mDbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(dbcontract.StudentEntry.COLUMN_NAME, nameString);
        values.put(dbcontract.StudentEntry.COLUMN_LOCATION,locationString);
        values.put(dbcontract.StudentEntry.COLUMN_MARKS, marks);

        long newRowId = db.insert(dbcontract.StudentEntry.STUDENT_TABLE_NAME, null, values);

        if (newRowId == -1) {
            Toast.makeText(getActivity(), "Error with saving ", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getActivity(), "Pet saved with row id: " + newRowId, Toast.LENGTH_SHORT).show();
        }
    }
    private void insertEmployee()
    {
        String nameString = Name.getText().toString().trim();
        String locationString = Location.getText().toString().trim();
        String salaryString = Marks.getText().toString().trim();
        int salary = Integer.parseInt(salaryString);

        edbhelper mDbHelper = new edbhelper(getActivity());

        SQLiteDatabase db = mDbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(edbcontract.EmployeeEntry.COLUMN_EMPLOYEE_NAME, nameString);
        values.put(edbcontract.EmployeeEntry.COLUMN_EMPLOYEE_LOCATION,locationString);
        values.put(edbcontract.EmployeeEntry.COLUMN_EMPLOYEE_SALARY, salary);

        long newRowId = db.insert(edbcontract.EmployeeEntry.EMPLOYEE_TABLE_NAME, null, values);

        if (newRowId == -1) {
            Toast.makeText(getActivity(), "Error with saving ", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getActivity(), "Pet saved with row id: " + newRowId, Toast.LENGTH_SHORT).show();
        }
    }

    private void insertTeacher()
    {
        String nameString = Name.getText().toString().trim();
        String locationString = Location.getText().toString().trim();
        String salaryString = Marks.getText().toString().trim();
        int salary = Integer.parseInt(salaryString);

        tdbhelper mDbHelper = new tdbhelper(getActivity());

        SQLiteDatabase db = mDbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(tdbcontract.TeacherEntry.COLUMN_TEACHER_NAME, nameString);
        values.put(tdbcontract.TeacherEntry.COLUMN_TEACHER_LOCATION,locationString);
        values.put(tdbcontract.TeacherEntry.COLUMN_TEACHER_SALARY, salary);

        long newRowId = db.insert(tdbcontract.TeacherEntry.TEACHER_TABLE_NAME, null, values);

        if (newRowId == -1) {
            Toast.makeText(getActivity(), "Error with saving ", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getActivity(), "Pet saved with row id: " + newRowId, Toast.LENGTH_SHORT).show();
        }
    }
    private void deleteall()
    {



    }


}
