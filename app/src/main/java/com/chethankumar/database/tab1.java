package com.chethankumar.database;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by chethan on 20/6/18.
 */

public class tab1  extends FragmentStatePagerAdapter {

    String [] tabarray=new String[]{"Insert","Student","Employee","Teacher"};
    int count=4;
    public tab1(FragmentManager fm) {
        super(fm);
    }
    @Override
    public CharSequence getPageTitle(int position)
    {
        return tabarray[position];
    }

    @Override
    public android.support.v4.app.Fragment getItem(int position) {

        switch (position)
        {
            case 0:insert one1=new insert();
                return one1;
            case 2: employee two2=new employee();
                return two2;
            case 1: student three3=new student();
                return three3;
            case 3:teacher four4=new teacher();
                return four4;



        }


        return null;
    }

    @Override
    public int getCount() {
        return count;
    }
}
