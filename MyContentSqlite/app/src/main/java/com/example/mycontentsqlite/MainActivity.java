package com.example.mycontentsqlite;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Uri u;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        u = Uri.parse("content://com.example.sqlitedbtest");
        tv = findViewById(R.id.textview);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void getData(View view) {
        Cursor c = getContentResolver().query(u,null,null,null);
        StringBuilder builder = new StringBuilder();
        while (c.moveToNext()){
            builder.append(c.getInt(0)+" "+c.getString(1)+" "+c.getString(2)+"\n");
        }

        tv.setText(builder.toString());

    }
}