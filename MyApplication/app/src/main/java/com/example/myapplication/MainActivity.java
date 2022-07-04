package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

//import com.example.myapplication.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
/*ActivityMainBinding binding;*/
    TextInputLayout editText;
    TextInputLayout passwordET;
    String username="muni";
    String password="1234";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText=findViewById(R.id.et_username);
        passwordET=findViewById(R.id.password);

    }

    public void submit(View view) {
        String name=editText.getEditText().toString();
        String pass=passwordET.getEditText().toString();
        if(name.isEmpty()||pass.isEmpty()){
            Toast.makeText(this, "please enter the details", Toast.LENGTH_SHORT).show();
        }else {
            if (name==username&&pass==password){
                Toast.makeText(this, "success", Toast.LENGTH_SHORT).show();
            }
        }
    }
}