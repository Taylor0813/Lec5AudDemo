package com.example.lec5auddemo;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import java.util.List;

public class SongAdapter extends BaseAdapter {
    //data
    List<Song> adapterSongs;

    //constructor

    public SongAdapter(List<Song> adapterSongs) {
        this.adapterSongs = adapterSongs;
    }

    //customize methods
    @Override
    public int getCount() {
        return adapterSongs.size();
    }

    @Override
    public Object getItem(int i) {
        return adapterSongs.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        //inflate
        if(view == null){
            //if view initially is null we need to inflate
            view = LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.layout_song,viewGroup,false);
        }
        //populate
        TextView txtViewSong = view.findViewById(R.id.txtViewSong);
        txtViewSong.setText(adapterSongs.get(i).getSongName());

        //Drawable object creation with the song pic
        Drawable img = ContextCompat.getDrawable(viewGroup.getContext(),
                        adapterSongs.get(i).getSongPic());
        //set the bounds (size) of the drawable
        img.setBounds(0,0,80,80);
        //set up compound drawables for textview
        txtViewSong.setCompoundDrawables(img,null,null,null);
        txtViewSong.setCompoundDrawablePadding(8);
        //return view
        return view;
    }
}
