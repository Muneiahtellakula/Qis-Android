package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
RecyclerView recycler;
String titles[];
String subTitles[];
int posters[];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recycler=findViewById(R.id.rv);
        titles=getResources().getStringArray(R.array.movie_Titles);
        subTitles=getResources().getStringArray(R.array.movie_hero);
        posters=new int[]{
                R.drawable.aa,
                R.drawable.bahu,
                R.drawable.ciruta,
                R.drawable.darling,
                R.drawable.eega,
                R.drawable.fida,
                R.drawable.ganga,
                R.drawable.husaru,
                R.drawable.i,
                R.drawable.julai,
        };
        MyAdapter adapter=new MyAdapter(this,titles,subTitles,posters);
        recycler.setLayoutManager(new LinearLayoutManager(this));
        recycler.setAdapter(adapter);
    }
}