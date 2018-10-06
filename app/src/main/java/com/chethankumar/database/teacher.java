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

import com.chethankumar.database.data.tdbcontract;
import com.chethankumar.database.data.tdbhelper;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class teacher extends Fragment {
    private tdbhelper mDbHelper;
    SQLiteDatabase db;
    RecyclerView listu;
    private ArrayList<listgaluhakakke> List1;
    recycleadapter mAdapter;
    public teacher() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View inflate = inflater.inflate(R.layout.fragment_teacher, container, false);
        listu=(RecyclerView)inflate.findViewById(R.id.tlist);
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










        mDbHelper=new tdbhelper(getActivity());

        displayDatabaseInfo();
        return inflate;
    }
    private void displayDatabaseInfo() {
        db = mDbHelper.getReadableDatabase();

        String[] projection = {
                tdbcontract.TeacherEntry._ID,
                tdbcontract.TeacherEntry.COLUMN_TEACHER_NAME,
                tdbcontract.TeacherEntry.COLUMN_TEACHER_LOCATION,
                tdbcontract.TeacherEntry.COLUMN_TEACHER_SALARY};

        Cursor cursor = db.query(
                tdbcontract.TeacherEntry.TEACHER_TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                null);



        try {


            int idColumnIndex = cursor.getColumnIndex(tdbcontract.TeacherEntry._ID);
            int nameColumnIndex = cursor.getColumnIndex(tdbcontract.TeacherEntry.COLUMN_TEACHER_NAME);
            int locationColumnIndex = cursor.getColumnIndex(tdbcontract.TeacherEntry.COLUMN_TEACHER_LOCATION);
            int marksColumnIndex = cursor.getColumnIndex(tdbcontract.TeacherEntry.COLUMN_TEACHER_SALARY);

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


