package com.example.sharedprefrencestest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText et_name,et_mobile;
    Button b_Save,b_retrive;
    TextView tv;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_name = findViewById(R.id.nameEdittext);
        et_mobile = findViewById(R.id.mobileEdittext);
        b_Save = findViewById(R.id.saveButton);
        b_retrive = findViewById(R.id.retriveButton);
        tv = findViewById(R.id.resultTextView);
        sharedPreferences = getSharedPreferences("PrefrenceFile",MODE_PRIVATE);
                //or
        /*//If you want to work with sharedprefrences in SingleActivity
        sharedPreferences = getPreferences(MODE_PRIVATE);*/
        b_Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //saveData
                String name = et_name.getText().toString();
                String mobileno = et_mobile.getText().toString();
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("key_name",name);
                editor.putString("key_mobile",mobileno);
                editor.apply();
                Toast.makeText(MainActivity.this, "Data Saved...", Toast.LENGTH_SHORT).show();

            }
        });

        b_retrive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String myName = sharedPreferences.getString("key_name","name is not found");
                String myMobile = sharedPreferences.getString("key_mobile","Mobileno not found");
                tv.setText(myName+" "+myMobile);

            }
        });

    }
}