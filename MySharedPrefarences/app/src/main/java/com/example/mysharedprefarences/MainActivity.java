package com.example.mysharedprefarences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
EditText etName,etPassword;
SharedPreferences sp;
SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etName=findViewById(R.id.et_username);
        etPassword=findViewById(R.id.et_password);
        sp=getSharedPreferences("myfle",MODE_PRIVATE);

    }

    public void submit(View view) {
        String name=etName.getText().toString();
        String password=etPassword.getText().toString();
        editor=sp.edit();
        editor.putString("n",name);
        editor.putString("p",password);
        editor.commit();
        Toast.makeText(this, "name :"+name+"\n"+"password "+password, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        String name=etName.getText().toString();
        String password=etPassword.getText().toString();
        editor=sp.edit();
        editor.putString("n",name);
        editor.putString("p",password);
        editor.commit();
    }

    @Override
    protected void onResume() {
        super.onResume();
        String myName=sp.getString("n",null);
        String myPassword=sp.getString("n",null);
        etName.setText(myName);
        etPassword.setText(myPassword);
    }
}