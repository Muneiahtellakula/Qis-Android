package com.example.explicitintenttest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button nextB;
    EditText et;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nextB = findViewById(R.id.nextButton);
        et = findViewById(R.id.userInputEdittext);
        nextB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userData = et.getText().toString();
                Intent i = new Intent(MainActivity.this,SecondActivity.class);
                i.putExtra("key",userData);
                startActivity(i);

            }
        });
    }
}