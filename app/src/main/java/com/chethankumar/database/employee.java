package com.chethankumar.database;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chethankumar.database.data.edbcontract;
import com.chethankumar.database.data.edbhelper;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class employee extends Fragment {
    private edbhelper mDbHelper;
    SQLiteDatabase db;
    RecyclerView listu;
    private ArrayList<listgaluhakakke> List1;
    recycleadapter mAdapter;


    public employee() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View inflate = inflater.inflate(R.layout.fragment_employee, container, false);

        mDbHelper=new edbhelper(getActivity());
        listu=(RecyclerView)inflate.findViewById(R.id.elist);
        List1=new ArrayList<listgaluhakakke>();






        mAdapter = new recycleadapter(getActivity(),List1);

        listu.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext());


        listu.setLayoutManager(mLayoutManager);


        listu.setItemAnimator(new DefaultItemAnimator());

        listu.setAdapter(mAdapter);









        listu.addOnItemTouchListener(new RecyclerTouchListener(getActivity().getApplicationContext(), listu, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {

            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));











        displayDatabaseInfo();
        return inflate;
    }
    private void displayDatabaseInfo() {
        db = mDbHelper.getReadableDatabase();

        String[] projection = {
                edbcontract.EmployeeEntry._ID,
                edbcontract.EmployeeEntry.COLUMN_EMPLOYEE_NAME,
                edbcontract.EmployeeEntry.COLUMN_EMPLOYEE_LOCATION,
                edbcontract.EmployeeEntry.COLUMN_EMPLOYEE_SALARY};

        Cursor cursor = db.query(
                edbcontract.EmployeeEntry.EMPLOYEE_TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                null);



        try {


            int idColumnIndex = cursor.getColumnIndex(edbcontract.EmployeeEntry._ID);
            int nameColumnIndex = cursor.getColumnIndex(edbcontract.EmployeeEntry.COLUMN_EMPLOYEE_NAME);
            int locationColumnIndex = cursor.getColumnIndex(edbcontract.EmployeeEntry.COLUMN_EMPLOYEE_LOCATION);
            int marksColumnIndex = cursor.getColumnIndex(edbcontract.EmployeeEntry.COLUMN_EMPLOYEE_SALARY);

            while (cursor.moveToNext()) {
                int currentID = cursor.getInt(idColumnIndex);
                String currentName = cursor.getString(nameColumnIndex);
                String currentLocation = cursor.getString(locationColumnIndex);
                int currentMarks = cursor.getInt(marksColumnIndex);
                List1.add(new listgaluhakakke(currentID,currentName,currentLocation,currentMarks));

            }
        } finally {
            cursor.close();
        }
    }


}
