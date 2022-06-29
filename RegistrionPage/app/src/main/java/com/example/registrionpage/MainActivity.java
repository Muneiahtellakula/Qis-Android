package com.example.registrionpage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.registrionpage.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       binding= DataBindingUtil.setContentView(this,R.layout.activity_main);
binding.submitButton.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        String name=binding.etUserName.getText().toString();
        String email=binding.etEmail.getText().toString();
        Toast.makeText(getApplicationContext(),
                "Name :"+name+
                "\n Email:"+email, Toast.LENGTH_SHORT).show();
    }
});
    }
}