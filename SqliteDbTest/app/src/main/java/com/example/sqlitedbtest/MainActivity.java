package com.example.sqlitedbtest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText et_name,et_mobile;
    Button b_save,b_retrive;
    TextView tv;
    DbHelper helper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_name = findViewById(R.id.nameEdittext);
        et_mobile = findViewById(R.id.mobileEdittext);
        b_save = findViewById(R.id.saveButton);
        b_retrive = findViewById(R.id.retriveButton);
        tv = findViewById(R.id.resultTextView);
        helper = new DbHelper(this);

        b_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = et_name.getText().toString();
                String mobile = et_mobile.getText().toString();
                ContentValues contentValues = new ContentValues();
                contentValues.put("name",name);
                contentValues.put("mobile",mobile);
                long i = helper.insertData(contentValues);
                if(i>0){
                    Toast.makeText(MainActivity.this, ""+i+" record inserted...", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(MainActivity.this, "Not inserted...", Toast.LENGTH_SHORT).show();
                }
            }
        });

        b_retrive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor c = helper.getData();
                StringBuilder builder = new StringBuilder();
                while (c.moveToNext()){
                    builder.append(c.getInt(0)+" "+c.getString(1)+" "+c.getString(2)+"\n");
                }

                tv.setText(builder.toString());

            }
        });

    }
}