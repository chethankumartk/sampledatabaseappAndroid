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

import com.chethankumar.database.data.dbcontract;
import com.chethankumar.database.data.dbhelper;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class student extends Fragment {

    private dbhelper mDbHelper;
    SQLiteDatabase db;
    //TextView displayView;
    RecyclerView listu;
    private ArrayList<listgaluhakakke> List1;
    recycleadapter mAdapter;

    public student() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_student, container, false);
      //  displayView = (TextView) inflate.findViewById(R.id.display);
        mDbHelper=new dbhelper(getActivity());
        listu=(RecyclerView)inflate.findViewById(R.id.listu1);
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
                dbcontract.StudentEntry._ID,
                dbcontract.StudentEntry.COLUMN_NAME,
                dbcontract.StudentEntry.COLUMN_LOCATION,
                dbcontract.StudentEntry.COLUMN_MARKS};

        Cursor cursor = db.query(
                dbcontract.StudentEntry.STUDENT_TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                null);



        try {


            int idColumnIndex = cursor.getColumnIndex(dbcontract.StudentEntry._ID);
            int nameColumnIndex = cursor.getColumnIndex(dbcontract.StudentEntry.COLUMN_NAME);
            int locationColumnIndex = cursor.getColumnIndex(dbcontract.StudentEntry.COLUMN_LOCATION);
            int marksColumnIndex = cursor.getColumnIndex(dbcontract.StudentEntry.COLUMN_MARKS);
            while (cursor.moveToNext()) {
                int currentID = cursor.getInt(idColumnIndex);
                String currentName = cursor.getString(nameColumnIndex);
                String currentLocation = cursor.getString(locationColumnIndex);
                int currentMarks = cursor.getInt(marksColumnIndex);
               // List1.add(currentID,currentName,currentLocation,currentMarks);
                List1.add(new listgaluhakakke(currentID,currentName,currentLocation,currentMarks));


            }
        } finally {
            cursor.close();
        }
    }

}
