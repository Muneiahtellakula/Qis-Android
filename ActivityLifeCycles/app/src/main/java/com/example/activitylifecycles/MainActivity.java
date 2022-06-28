package com.example.activitylifecycles;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
TextView tv_label;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_label=findViewById(R.id.tv);
        Toast.makeText(this, "App is Created", Toast.LENGTH_SHORT).show();
        tv_label.append("App is Created");
        Log.i("MainActivity","App is Created");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "App is Started", Toast.LENGTH_SHORT).show();
        tv_label.append("App is Started");
        Log.i("MainActivity","App is Started");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "App is Resumed", Toast.LENGTH_SHORT).show();
        tv_label.append("App is Resumed");
        Log.i("MainActivity","App is Resumed");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "App is Stopped", Toast.LENGTH_SHORT).show();
        tv_label.append("App is Stopped");
        Log.i("MainActivity","App is Stopped");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "App is Paused", Toast.LENGTH_SHORT).show();
        tv_label.append("App is Paused");
        Log.i("MainActivity","App is Paused");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(this, "App is ReStarted", Toast.LENGTH_SHORT).show();
        tv_label.append("App is ReStarted");
        Log.i("MainActivity","App is ReStarted");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "App is Destroy", Toast.LENGTH_SHORT).show();
        tv_label.append("App is Destroy");
        Log.i("MainActivity","App is Destored");
    }
}