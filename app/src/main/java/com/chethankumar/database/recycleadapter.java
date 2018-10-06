package com.chethankumar.database;

/**
 * Created by chethan on 22/6/18.
 */


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;


public class recycleadapter extends RecyclerView.Adapter<recycleadapter.MyViewHolder> {

    //song list and layout
    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView tid,tname,tloc,tmark;



        public MyViewHolder(View view) {
            super(view);
            tid = (TextView) view.findViewById(R.id.idd);
            tname = (TextView) view.findViewById(R.id.names);
            tloc = (TextView) view.findViewById(R.id.loc);
            tmark =(TextView)view.findViewById(R.id.mark);


        }
    }


    private ArrayList<listgaluhakakke> listt;
    private LayoutInflater songInf;

    //  LinearLayout itemView;
    //constructor
    public recycleadapter(Context c, ArrayList<listgaluhakakke> theSongs) {
        listt = theSongs;
        songInf = LayoutInflater.from(c);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LinearLayout itemView = (LinearLayout) songInf.inflate(R.layout.lists, parent, false);
        //LinearLayout songLay = (LinearLayout)songInf.inflate
        // (R.layout.song, parent, false);
        itemView.setTag(this);


        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        // Movie movie = moviesList.get(position);
        holder.itemView.setTag(position);

        listgaluhakakke currSong = listt.get(position);
        holder.tid.setText(String.valueOf(currSong.getid()));
        holder.tname.setText(currSong.getname());
        holder.tloc.setText(currSong.getlocation());
        holder.tmark.setText(String.valueOf(currSong.getmarksrsal()));




        //itemView.setTag(position);
        //holder.year.setText(movie.getYear());
    }

    @Override
    public long getItemId(int arg0) {
        return 0;
    }

    @Override
    public int getItemCount() {
        return listt.size();
    }


}






































