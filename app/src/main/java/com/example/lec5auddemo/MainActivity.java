package com.example.lec5auddemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<String> SongNames = new ArrayList<>
                                (Arrays.asList("Bag Pipes", "Ukulele", "Drums"));
    List<Integer> SongPics = new ArrayList<>
                                (Arrays.asList(R.drawable.bagpipes,
                                        R.drawable.ukulele, R.drawable.drums));
    List<Integer> SongRaws = new ArrayList<>
                                (Arrays.asList(R.raw.bagpipes,
                                        R.raw.ukulele, R.raw.drums));
    List<Song> SongList = new ArrayList<>();  //initialize the SongList to be an empty list so that we can use the add() method

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LoadModelData(); //call the method

        //Instantiate ListView
        ListView listViewSongs = findViewById(R.id.listViewSongs);

        //Crate adapter object
        SongAdapter myAdapter = new SongAdapter(SongList);

        //Set adapter object onto ListView
        listViewSongs.setAdapter(myAdapter);

        //Set onItemClick listener for ListView
    }

    private void LoadModelData(){   //create song list
        for(int i = 0; i < SongNames.size(); i++){
            Song eachSong = new Song(SongNames.get(i), SongPics.get(i), SongRaws.get(i)); //create the objects
            SongList.add(eachSong); //SongList is not null
        }
    }

}