package com.chethankumar.database;

/**
 * Created by chethan on 22/6/18.
 */



public class listgaluhakakke {

    private int a;
    private String b;
    private String c;
    private int d;

    public listgaluhakakke(int id, String name, String location,int marksrsal) {
        a=id;
        b=name;
        c=location;
        d=marksrsal;
    }


    public int getid(){return a;}
    public String getname(){return b;}
    public String getlocation(){return c;}
    public int getmarksrsal(){return d;}


}
